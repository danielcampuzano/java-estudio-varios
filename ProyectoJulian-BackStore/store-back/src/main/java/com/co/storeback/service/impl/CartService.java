package com.co.storeback.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestAddCartProductDTO;
import com.co.storeback.dto.ResponseCartProductDTO;
import com.co.storeback.entity.ProductEntity;
import com.co.storeback.exception.BusinessStoreException;
import com.co.storeback.parser.PriceParser;
import com.co.storeback.repository.IProductRepository;
import com.co.storeback.service.ICartService;
import com.co.storeback.util.MessageConstant;

@Service
public class CartService implements ICartService {

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private MessageSourceComponent messageSource;

	@Value("${url.path.image.store}")
	private String urlImageStore;

	private static Map<String, List<RequestAddCartProductDTO>> cart;

	public CartService() {
		cart = new HashMap<String, List<RequestAddCartProductDTO>>();
	}

	@Override
	public List<ResponseCartProductDTO> addCartProducts(String identifier, RequestAddCartProductDTO cartProductDTO)
			throws BusinessStoreException {
		Date now = new Date();
		List<RequestAddCartProductDTO> listCart = getCart(identifier);

		if (listCart.stream().filter(x -> x.getIdProduct() == cartProductDTO.getIdProduct()).findFirst().isPresent()) {
			listCart = listCart.stream()
					.map(x -> x.getIdProduct() == cartProductDTO.getIdProduct() ? cartProductDTO : x)
					.collect(Collectors.toList());
		} else {
			Optional<ProductEntity> optionalProduct = productRepository.findById(cartProductDTO.getIdProduct());

			if (!optionalProduct.isPresent()) {
				throw new BusinessStoreException(messageSource.getMessage(MessageConstant.ERROR_PRODUCT_CART,
						new Object[] { cartProductDTO.getProductName() }));
			}

			if (PriceParser.buildPriceDTO(optionalProduct.get().getIdReference().getPriceEntityList(), now) == null) {
				throw new BusinessStoreException(messageSource.getMessage(MessageConstant.ERROR_PRODUCT_CART_PRICE,
						new Object[] { cartProductDTO.getProductName() }));
			}

			listCart.add(cartProductDTO);
		}

		cart.put(identifier, listCart);

		return findCartProducts(identifier);
	}

	@Override
	public List<ResponseCartProductDTO> findCartProducts(String identifier) {
		Date now = new Date();
		List<ResponseCartProductDTO> productDTOs = new ArrayList<ResponseCartProductDTO>();
		List<RequestAddCartProductDTO> listCart = getCart(identifier);

		getCart(identifier);

		for (RequestAddCartProductDTO requestAddCartProductDTO : listCart) {
			ProductEntity productEntity = productRepository.findById(requestAddCartProductDTO.getIdProduct())
					.orElse(null);

			ResponseCartProductDTO responseCartProductDTO = new ResponseCartProductDTO();

			responseCartProductDTO.setIdProduct(productEntity.getId());
			responseCartProductDTO.setSize(productEntity.getIdSize().getDescription());
			responseCartProductDTO.setColor(productEntity.getIdColor().getName());
			responseCartProductDTO.setQuantity(requestAddCartProductDTO.getQuantity());
			responseCartProductDTO.setNameProduct(productEntity.getIdReference().getName());
			responseCartProductDTO
					.setPriceUnit(PriceParser.buildPriceDTO(productEntity.getIdReference().getPriceEntityList(), now));
			BigDecimal total = responseCartProductDTO.getPriceUnit().getTotalPrice()
					.multiply(new BigDecimal(responseCartProductDTO.getQuantity())).setScale(2, RoundingMode.HALF_UP);
			responseCartProductDTO.setTotal(total);

			String urlImage = String.format(urlImageStore, productEntity.getIdReference().getCodigo(),
					productEntity.getIdColor().getCode(), productEntity.getIdReference().getCodigo(),
					productEntity.getIdColor().getCode());

			responseCartProductDTO.setImage(urlImage.split(";"));

			productDTOs.add(responseCartProductDTO);
		}

		return productDTOs;
	}

	private List<RequestAddCartProductDTO> getCart(String identifier) {
		return (cart.containsKey(identifier)) ? cart.get(identifier) : (new ArrayList<RequestAddCartProductDTO>());
	}

}

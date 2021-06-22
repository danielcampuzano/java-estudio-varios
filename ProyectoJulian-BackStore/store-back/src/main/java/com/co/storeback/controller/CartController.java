package com.co.storeback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestAddCartProductDTO;
import com.co.storeback.dto.ResponseCartProductDTO;
import com.co.storeback.dto.ResponseDTO;
import com.co.storeback.exception.BusinessStoreException;
import com.co.storeback.service.ICartService;
import com.co.storeback.util.MessageConstant;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ICartService cartService;

	@Autowired
	private MessageSourceComponent messageSource;

	@GetMapping(path = "/{identifier}")
	public ResponseDTO<List<ResponseCartProductDTO>> findCart(@PathVariable("identifier") String identifier,
			@RequestBody RequestAddCartProductDTO cartProductDTO) {
		ResponseDTO<List<ResponseCartProductDTO>> responseDTO = new ResponseDTO<List<ResponseCartProductDTO>>();
		try {
			responseDTO.setData(cartService.findCartProducts(identifier));
			responseDTO.setSuccess(true);
		} catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}

		return responseDTO;
	}

	@PutMapping(path = "/{identifier}")
	public ResponseDTO<List<ResponseCartProductDTO>> addCart(@PathVariable("identifier") String identifier,
			@RequestBody RequestAddCartProductDTO cartProductDTO) {
		ResponseDTO<List<ResponseCartProductDTO>> responseDTO = new ResponseDTO<List<ResponseCartProductDTO>>();
		try {
			responseDTO.setData(cartService.addCartProducts(identifier, cartProductDTO));
			responseDTO.setSuccess(true);
		} catch (BusinessStoreException bse) {
			responseDTO.setMessage(bse.getMessage());
		} catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}

		return responseDTO;
	}

}

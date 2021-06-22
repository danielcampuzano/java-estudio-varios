package com.co.storeback.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestPriceDTO;
import com.co.storeback.dto.RequestSearchReferencesDTO;
import com.co.storeback.dto.ResponseColorDTO;
import com.co.storeback.dto.ResponseProductDto;
import com.co.storeback.dto.ResponseSearchReferencesDTO;
import com.co.storeback.entity.PriceEntity;
import com.co.storeback.entity.ProductEntity;
import com.co.storeback.entity.ReferenceEntity;
import com.co.storeback.enums.StatusReferenceEnum;
import com.co.storeback.enums.VisibleReferenceEnum;
import com.co.storeback.exception.BusinessStoreException;
import com.co.storeback.parser.CategoryParser;
import com.co.storeback.parser.PriceParser;
import com.co.storeback.repository.IPriceRepository;
import com.co.storeback.repository.IReferenceRepository;
import com.co.storeback.service.IReferenceService;
import com.co.storeback.util.MessageConstant;

@Service
public class ReferenceService implements IReferenceService {

	@Autowired
	private IReferenceRepository referenceRepository;

	@Autowired
	private IPriceRepository priceRepository;

	@Autowired
	private MessageSourceComponent messageSource;

	@Value("${url.path.image.store}")
	private String urlImageStore;

	public List<ResponseSearchReferencesDTO> searchReferences(RequestSearchReferencesDTO searchReferencesDTO,
			boolean completeData) {
		Pageable pageable = PageRequest.of(searchReferencesDTO.getPage(), searchReferencesDTO.getLimit(),
				Sort.by("searchQuanty").descending());
		Date now = new Date();

		List<ResponseSearchReferencesDTO> responseSearchDTO = new ArrayList<ResponseSearchReferencesDTO>();
		List<ReferenceEntity> references = null;

		if (searchReferencesDTO.getName() != null && !searchReferencesDTO.getName().isEmpty()
				&& searchReferencesDTO.getCategory() != null) {
			references = referenceRepository
					.findDistinctByNameContainingIgnoreCaseAndIdCategoryIdAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
							searchReferencesDTO.getName(), searchReferencesDTO.getCategory(), StatusReferenceEnum.A,
							VisibleReferenceEnum.A, now, now, pageable);
		} else if (searchReferencesDTO.getCategory() != null) {
			references = referenceRepository
					.findDistinctByIdCategoryIdAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
							searchReferencesDTO.getCategory(), StatusReferenceEnum.A, VisibleReferenceEnum.A, now, now,
							pageable);
		} else if (searchReferencesDTO.getName() != null && !searchReferencesDTO.getName().isEmpty()) {
			references = referenceRepository
					.findDistinctByNameContainingIgnoreCaseAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
							searchReferencesDTO.getName(), StatusReferenceEnum.A, VisibleReferenceEnum.A, now, now,
							pageable);
		} else {
			references = referenceRepository
					.findDistinctByStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
							StatusReferenceEnum.A, VisibleReferenceEnum.A, now, now, pageable);
		}

		if (references != null) {
			for (ReferenceEntity referenceEntity : references) {
				responseSearchDTO.add(buildReferenceDTO(referenceEntity, now, completeData));
			}
		}

		return responseSearchDTO;

	}

	public ResponseSearchReferencesDTO buildReferenceDTO(ReferenceEntity referenceEntity, Date filterDate,
			boolean completeData) {
		ResponseSearchReferencesDTO reDto = null;
		if (referenceEntity != null) {
			reDto = new ResponseSearchReferencesDTO();

			reDto.setId(referenceEntity.getId());
			reDto.setName(referenceEntity.getName());

			if (completeData) {
				reDto.setDescription(referenceEntity.getDescription());

				if (referenceEntity.getIdCategory() != null)
					reDto.setCategory(
							CategoryParser.categoryEntityToResponseCategoryDTO(referenceEntity.getIdCategory(), null));
			}

			reDto.setColor(new ArrayList<ResponseColorDTO>());

			buildProductDTO(referenceEntity, reDto.getColor(), completeData);

			reDto.setPrice(PriceParser.buildPriceDTO(referenceEntity.getPriceEntityList(), filterDate));
		}
		return reDto;
	}

	public void buildProductDTO(ReferenceEntity referenceEntity, List<ResponseColorDTO> colorDto,
			boolean completeData) {
		if (referenceEntity.getProductEntityList() != null) {
			Map<String, List<ProductEntity>> products = referenceEntity.getProductEntityList().stream()
					.collect(Collectors.groupingBy(x -> x.getIdColor().getCode()));

			Iterator<String> val = products.keySet().iterator();

			while (val.hasNext()) {
				String key = val.next();

				ResponseColorDTO responseColorDTO = new ResponseColorDTO();
				responseColorDTO.setCode(key);

				String urlImage = String.format(urlImageStore, referenceEntity.getCodigo(), key,
						referenceEntity.getCodigo(), key);

				responseColorDTO.setImage(urlImage.split(";"));

				if (completeData) {
					responseColorDTO.setProducts(new ArrayList<ResponseProductDto>());
					for (ProductEntity p : products.get(key)) {

						if (responseColorDTO.getName() == null || responseColorDTO.getName().trim().isEmpty()) {
							responseColorDTO.setName(p.getIdColor().getName());
						}

						ResponseProductDto responseProductDto = new ResponseProductDto();

						responseProductDto.setId(p.getId());
						responseProductDto.setEan(p.getEan());
						responseProductDto.setTalla(p.getIdSize().getDescription());

						responseColorDTO.getProducts().add(responseProductDto);
					}
				} else {
					Optional<ProductEntity> productEntity = products.get(key).stream().findFirst();

					responseColorDTO
							.setName(productEntity.isPresent() ? productEntity.get().getIdColor().getName() : null);
				}

				colorDto.add(responseColorDTO);
			}
		}
	}

	public ResponseSearchReferencesDTO findByReference(Integer idReference, boolean completeData)
			throws BusinessStoreException {
		Date now = new Date();
		Optional<ReferenceEntity> optionalReference = referenceRepository
				.findDistinctByIdAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
						idReference, StatusReferenceEnum.A, VisibleReferenceEnum.A, now, now);

		if (!optionalReference.isPresent()) {
			throw new BusinessStoreException(
					messageSource.getMessage(MessageConstant.ID_REFERENCE_NOT_FOUND, new Object[] { idReference }));
		}

		return optionalReference.isPresent() ? buildReferenceDTO(optionalReference.get(), now, completeData) : null;
	}

	@Async("threadPoolTaskExecutor")
	@Transactional(value = TxType.REQUIRES_NEW)
	public void updateSearchQuanty(List<Integer> listIdReferences) {
		if (listIdReferences != null && !listIdReferences.isEmpty())
			referenceRepository.updateSearchQuantyReference(listIdReferences);
	}

	@Override
	public void assignPrice(RequestPriceDTO requestPriceDTO, Integer idReference) throws BusinessStoreException {
		Date now = new Date();
		if (now.after(requestPriceDTO.getStartDate())) {
			throw new BusinessStoreException(messageSource.getMessage(MessageConstant.INVALID_START_DATE));
		}

		if (requestPriceDTO.getEndDate().before(requestPriceDTO.getStartDate())) {
			throw new BusinessStoreException(messageSource.getMessage(MessageConstant.INVALID_END_DATE));
		}

		BigDecimal per = requestPriceDTO.getDiscountPer().divide(new BigDecimal(100));

		BigDecimal disCost = requestPriceDTO.getCost().multiply(per).setScale(2, RoundingMode.HALF_UP);

		BigDecimal totalCost = requestPriceDTO.getCost().subtract(disCost).setScale(2, RoundingMode.HALF_UP);

		if (totalCost.compareTo(requestPriceDTO.getTotalCost()) != 0
				|| disCost.compareTo(requestPriceDTO.getDiscountCost()) != 0) {
			throw new BusinessStoreException(messageSource.getMessage(MessageConstant.INVALID_COST));
		}

		Optional<ReferenceEntity> optionalReference = referenceRepository.findById(idReference);

		if (!optionalReference.isPresent()) {
			throw new BusinessStoreException(
					messageSource.getMessage(MessageConstant.ID_REFERENCE_NOT_FOUND, new Object[] { idReference }));
		}

		PriceEntity priceEntity = PriceParser.RequestPriceDTOToPriceEntity(requestPriceDTO, optionalReference.get());
		priceRepository.save(priceEntity);
	}

}

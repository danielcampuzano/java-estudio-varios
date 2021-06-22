package com.co.storeback.parser;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.co.storeback.dto.RequestPriceDTO;
import com.co.storeback.dto.ResponsePriceDTO;
import com.co.storeback.entity.PriceEntity;
import com.co.storeback.entity.ReferenceEntity;
import com.co.storeback.enums.StatusPriceEnum;

public class PriceParser {
	
	public static PriceEntity RequestPriceDTOToPriceEntity(RequestPriceDTO priceDTO, ReferenceEntity referenceEntity) {
		PriceEntity priceEntity = new PriceEntity();
		
		if(priceDTO != null && referenceEntity != null) {
			priceEntity.setCost(priceDTO.getCost());
			priceEntity.setDiscountPer(priceDTO.getDiscountPer());
			priceEntity.setDiscountCost(priceDTO.getDiscountCost());
			priceEntity.setTotalCost(priceDTO.getTotalCost());
			priceEntity.setStartDate(priceDTO.getStartDate());
			priceEntity.setEndDate(priceDTO.getEndDate());
			priceEntity.setStatus(StatusPriceEnum.A);
			priceEntity.setIdReference(referenceEntity);
		}
		
		return priceEntity;
	}

	public static ResponsePriceDTO PriceEntityToResponsePriceDTO(PriceEntity priceEntity) {
		ResponsePriceDTO priceDTO=null;

		if (priceEntity != null) {
			priceDTO = new ResponsePriceDTO();
			priceDTO.setPrice(priceEntity.getCost());
			priceDTO.setDiscountPer(priceEntity.getDiscountPer());
			priceDTO.setTotalPrice(priceEntity.getTotalCost());
		}
		return priceDTO;
	}
	
	public static ResponsePriceDTO buildPriceDTO(List<PriceEntity> listPrice, Date filterDate) {
		Optional<PriceEntity> price = listPrice.stream()
				.filter(x -> x.getStartDate().before(filterDate) && x.getEndDate().after(filterDate))
				.sorted(Comparator.comparingInt(PriceEntity::getId).reversed()).findFirst();

		return price.isPresent() ? PriceParser.PriceEntityToResponsePriceDTO(price.get()) : null;
	}
	
}

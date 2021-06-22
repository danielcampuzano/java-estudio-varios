package com.co.storeback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.storeback.dto.ResponseSearchReferencesDTO;
import com.co.storeback.entity.CategoryEntity;
import com.co.storeback.entity.PriceEntity;
import com.co.storeback.entity.ReferenceEntity;
import com.co.storeback.enums.StatusCategoryEnum;
import com.co.storeback.enums.StatusPriceEnum;
import com.co.storeback.enums.StatusProductEnum;
import com.co.storeback.service.impl.ReferenceService;

@SpringBootTest
public class ReferenceServiceTest {

	@Autowired
	private ReferenceService referenceService;

	@Test
	public void testReferenceDTONull() {
		Date now = new Date();

		ResponseSearchReferencesDTO searchReferencesDTO = referenceService.buildReferenceDTO(null, now, false);

		assertNull(searchReferencesDTO);
	}

	@Test
	public void testReferenceDTO() {
		Date startDate = Date.from(LocalDate.now().plusDays(-7).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(LocalDate.now().plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant());

		List<PriceEntity> prices = new ArrayList<PriceEntity>();
		PriceEntity priceEntity = new PriceEntity(1, new BigDecimal(10000), new BigDecimal(10), new BigDecimal(1000),
				new BigDecimal(9000), startDate, endDate, StatusPriceEnum.A);
		
		prices.add(priceEntity);

		ReferenceEntity referenceEntity = new ReferenceEntity();

		referenceEntity.setId(1);
		referenceEntity.setCodigo("123");
		referenceEntity.setName("Jeans 123");
		referenceEntity.setIdCategory(loadCategory());
		referenceEntity.setPriceEntityList(prices);

		ResponseSearchReferencesDTO searchReferencesDTO = referenceService.buildReferenceDTO(referenceEntity,
				new Date(), false);

		assertNotNull(searchReferencesDTO);
		assertEquals(searchReferencesDTO.getPrice().getTotalPrice(), priceEntity.getTotalCost());
		assertEquals(searchReferencesDTO.getName(), referenceEntity.getName());
	}

	private CategoryEntity loadCategory() {
		CategoryEntity categoryEntity = new CategoryEntity(1, "Hombre", StatusCategoryEnum.A);
		CategoryEntity sonCategoryEntity = new CategoryEntity(2, "Jeans", StatusCategoryEnum.A);
		sonCategoryEntity.setIdCategory(categoryEntity);

		return sonCategoryEntity;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.storeback.repository;

import com.co.storeback.entity.ReferenceEntity;
import com.co.storeback.enums.StatusReferenceEnum;
import com.co.storeback.enums.VisibleReferenceEnum;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface IReferenceRepository extends PagingAndSortingRepository<ReferenceEntity, Integer> {

	List<ReferenceEntity> findDistinctByNameContainingIgnoreCaseAndIdCategoryIdAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
			String name, Integer category, StatusReferenceEnum statusReference, VisibleReferenceEnum visibleReference,
			Date startDate, Date endDate, Pageable pageable);

	List<ReferenceEntity> findDistinctByIdCategoryIdAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
			Integer category, StatusReferenceEnum statusReference, VisibleReferenceEnum visibleReference,
			Date startDate, Date endDate, Pageable pageable);

	List<ReferenceEntity> findDistinctByNameContainingIgnoreCaseAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
			String name, StatusReferenceEnum statusReference, VisibleReferenceEnum visibleReference, Date startDate,
			Date endDate, Pageable pageable);

	List<ReferenceEntity> findDistinctByStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
			StatusReferenceEnum statusReference, VisibleReferenceEnum visibleReference, Date startDate, Date endDate,
			Pageable pageable);
	
	Optional<ReferenceEntity> findDistinctByIdAndStatusAndVisibleAndProductEntityListIsNotEmptyAndPriceEntityListStartDateLessThanEqualAndPriceEntityListEndDateGreaterThanEqual(
			Integer IdReference, StatusReferenceEnum statusReference, VisibleReferenceEnum visibleReference,
			Date startDate, Date endDate);

	Optional<ReferenceEntity> findByProductEntityListId(Integer idProduct);
	
	@Modifying
	@Query(nativeQuery = true, value = "update reference set search_quanty = search_quanty + 1 where id in :listIdReference")
	void updateSearchQuantyReference(@Param("listIdReference") List<Integer> listIdReference);

}

package com.co.storeback.service;

import java.util.List;

import com.co.storeback.dto.RequestNewCategoryDTO;
import com.co.storeback.dto.ResponseCategoryDTO;
import com.co.storeback.dto.ResponseTreeCategoryDTO;
import com.co.storeback.enums.StatusCategoryEnum;
import com.co.storeback.exception.BusinessStoreException;

public interface ICategoryService {

	List<ResponseTreeCategoryDTO> findAll();
	ResponseCategoryDTO createCategory(RequestNewCategoryDTO categoryDTO) throws BusinessStoreException;
	void updateStatusCategory(Integer idCategory, StatusCategoryEnum statusCategory) throws BusinessStoreException;
	
}

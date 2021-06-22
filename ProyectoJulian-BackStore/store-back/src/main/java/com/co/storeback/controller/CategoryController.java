package com.co.storeback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestNewCategoryDTO;
import com.co.storeback.dto.ResponseCategoryDTO;
import com.co.storeback.dto.ResponseDTO;
import com.co.storeback.dto.ResponseTreeCategoryDTO;
import com.co.storeback.enums.StatusCategoryEnum;
import com.co.storeback.exception.BusinessStoreException;
import com.co.storeback.service.ICategoryService;
import com.co.storeback.util.MessageConstant;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageSourceComponent messageSource;

	@GetMapping
	public ResponseDTO<List<ResponseTreeCategoryDTO>> viewCategory() {
		ResponseDTO<List<ResponseTreeCategoryDTO>> responseDTO = new ResponseDTO<List<ResponseTreeCategoryDTO>>();
		try {
			responseDTO.setData(categoryService.findAll());
			responseDTO.setSuccess(true);
		} catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;
	}

	@PostMapping
	public ResponseDTO<ResponseCategoryDTO> createCategory(@RequestBody @Validated RequestNewCategoryDTO categoryDTO) {
		ResponseDTO<ResponseCategoryDTO> responseDTO = new ResponseDTO<ResponseCategoryDTO>();
		try {
			responseDTO.setData(categoryService.createCategory(categoryDTO));
			responseDTO.setSuccess(true);
		} catch (BusinessStoreException bse) {
			responseDTO.setMessage(bse.getMessage());

		} catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;
	}

	@PutMapping(path = "/{idCategory}/status/{statusCategory}")
	public ResponseDTO<String> updateStatus(@PathVariable("idCategory") Integer idCategory,
			@PathVariable("statusCategory") StatusCategoryEnum statusCategory) {
		ResponseDTO<String> responseDTO = new ResponseDTO<String>();
		try {
			categoryService.updateStatusCategory(idCategory, statusCategory);
			responseDTO.setSuccess(true);
		} catch (BusinessStoreException bse) {
			responseDTO.setMessage(bse.getMessage());

		} catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;
	}

}

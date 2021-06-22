package com.co.storeback.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.co.storeback.dto.ResponseCategoryDTO;
import com.co.storeback.dto.ResponseTreeCategoryDTO;
import com.co.storeback.entity.CategoryEntity;

public class CategoryParser {

	public static ResponseCategoryDTO categoryEntityToResponseCategoryDTO(CategoryEntity category,
			ResponseCategoryDTO categoryDTO) {
		ResponseCategoryDTO categoryDTO2 = new ResponseCategoryDTO();

		categoryDTO2.setId(category.getId());
		categoryDTO2.setName(category.getName());

		if (categoryDTO != null) {
			categoryDTO2.setCategory(categoryDTO);
		}
		
		if (category.getIdCategory() == null) {
			return categoryDTO2;
		} else {
			return CategoryParser.categoryEntityToResponseCategoryDTO(category.getIdCategory(), categoryDTO2);
		}
	}

	public static List<ResponseTreeCategoryDTO> showCategoryTree(List<CategoryEntity> listCategories) {
		List<ResponseTreeCategoryDTO> categoryDTOs = new ArrayList<ResponseTreeCategoryDTO>();
		if (listCategories != null) {
			List<CategoryEntity> rootCategories = listCategories.stream().filter(x -> x.getIdCategory() == null)
					.collect(Collectors.toList());

			for (CategoryEntity categoryEntity : rootCategories) {
				ResponseTreeCategoryDTO categoryDTO2 = new ResponseTreeCategoryDTO();

				categoryDTO2.setId(categoryEntity.getId());
				categoryDTO2.setName(categoryEntity.getName());
				categoryDTO2.setCategories(CategoryParser.showCategoryTree(categoryEntity.getId(), listCategories));

				categoryDTOs.add(categoryDTO2);
			}
		}
		return categoryDTOs;
	}

	public static List<ResponseTreeCategoryDTO> showCategoryTree(Integer idRootCategory,
			List<CategoryEntity> listCategories) {
		if (idRootCategory != null) {
			List<ResponseTreeCategoryDTO> categoryDTOs = new ArrayList<ResponseTreeCategoryDTO>();

			List<CategoryEntity> rootCategories = listCategories.stream()
					.filter(x -> x.getIdCategory() != null && x.getIdCategory().getId() == idRootCategory)
					.collect(Collectors.toList());

			for (CategoryEntity categoryEntity : rootCategories) {
				ResponseTreeCategoryDTO categoryDTO2 = new ResponseTreeCategoryDTO();

				categoryDTO2.setId(categoryEntity.getId());
				categoryDTO2.setName(categoryEntity.getName());
				categoryDTO2.setCategories(CategoryParser.showCategoryTree(categoryEntity.getId(), listCategories));

				categoryDTOs.add(categoryDTO2);
			}

			return categoryDTOs;
		} else {
			return null;
		}
	}

}

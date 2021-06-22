package com.co.storeback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestNewCategoryDTO;
import com.co.storeback.dto.ResponseCategoryDTO;
import com.co.storeback.dto.ResponseTreeCategoryDTO;
import com.co.storeback.entity.CategoryEntity;
import com.co.storeback.enums.StatusCategoryEnum;
import com.co.storeback.exception.BusinessStoreException;
import com.co.storeback.parser.CategoryParser;
import com.co.storeback.repository.ICategoryRepository;
import com.co.storeback.service.ICategoryService;
import com.co.storeback.util.MessageConstant;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private MessageSourceComponent messageSource;

	public List<ResponseTreeCategoryDTO> findAll() {
		List<CategoryEntity> categories = categoryRepository.findByStatus(StatusCategoryEnum.A);

		return CategoryParser.showCategoryTree(categories);
	}

	public ResponseCategoryDTO createCategory(RequestNewCategoryDTO categoryDTO) throws BusinessStoreException {
		CategoryEntity cEntity = null;
		if (categoryDTO.getIdRootCategory() != null) {
			Optional<CategoryEntity> rootCategory = categoryRepository.findById(categoryDTO.getIdRootCategory());

			if (!rootCategory.isPresent()) {
				throw new BusinessStoreException(messageSource.getMessage(MessageConstant.ID_CATEGORY_NOT_FOUND,
						new Object[] { categoryDTO.getIdRootCategory() }));
			} else {
				cEntity = rootCategory.get();

				if (cEntity.getStatus() != StatusCategoryEnum.A) {
					throw new BusinessStoreException(messageSource.getMessage(MessageConstant.ID_CATEGORY_INACTIVE,
							new Object[] { cEntity.getId(), cEntity.getName() }));
				}
			}
		}

		CategoryEntity categoryEntity = new CategoryEntity();

		categoryEntity.setName(categoryDTO.getName());
		categoryEntity.setStatus(categoryDTO.getStatus());
		categoryEntity.setIdCategory(cEntity);

		return CategoryParser.categoryEntityToResponseCategoryDTO(categoryRepository.save(categoryEntity), null);

	}

	@Override
	public void updateStatusCategory(Integer idCategory, StatusCategoryEnum statusCategory)
			throws BusinessStoreException {
		Optional<CategoryEntity> caOptional = categoryRepository.findById(idCategory);

		if (!caOptional.isPresent()) {
			throw new BusinessStoreException(
					messageSource.getMessage(MessageConstant.ID_CATEGORY_NOT_FOUND, new Object[] { idCategory }));
		}

		CategoryEntity categoryEntity = caOptional.get();

		categoryEntity.setStatus(statusCategory);

		categoryRepository.save(categoryEntity);
	}

}

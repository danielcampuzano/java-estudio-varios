package com.co.storeback.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.storeback.dto.RequestNewColorDTO;
import com.co.storeback.dto.ResponseColorDTO;
import com.co.storeback.entity.ColorEntity;
import com.co.storeback.enums.StatusColorEnum;
import com.co.storeback.repository.IColorRepository;
import com.co.storeback.service.IColorService;

@Service
public class ColorService implements IColorService {

	@Autowired
	private IColorRepository colorRepository;

	@Override
	public void createColor(RequestNewColorDTO colorDTO) {
		ColorEntity color = new ColorEntity();

		color.setCode(colorDTO.getCode());
		color.setName(colorDTO.getName());
		color.setStatus(StatusColorEnum.A);

		colorRepository.save(color);
	}

	@Override
	public List<ResponseColorDTO> findAll() {
		List<ColorEntity> listColor = colorRepository.findAll();
		List<ResponseColorDTO> colorDTOs = new ArrayList<ResponseColorDTO>();
		for (ColorEntity colorEntity : listColor) {
			ResponseColorDTO colorDTO = new ResponseColorDTO();

			colorDTO.setId(colorEntity.getId());
			colorDTO.setCode(colorEntity.getCode());
			colorDTO.setName(colorEntity.getName());

			colorDTOs.add(colorDTO);
		}
		return colorDTOs;
	}

}

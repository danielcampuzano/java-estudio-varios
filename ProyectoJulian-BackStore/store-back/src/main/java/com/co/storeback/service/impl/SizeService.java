package com.co.storeback.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.storeback.dto.RequestSizeDTO;
import com.co.storeback.dto.ResponseSizeDTO;
import com.co.storeback.entity.SizeEntity;
import com.co.storeback.enums.StatusSizeEnum;
import com.co.storeback.repository.ISizeRepository;
import com.co.storeback.service.ISizeService;

@Service
public class SizeService implements ISizeService {

	@Autowired
	private ISizeRepository sizeRepository;

	@Override
	public List<ResponseSizeDTO> findAll() {
		List<SizeEntity> entities = sizeRepository.findAll();
		List<ResponseSizeDTO> responseSizeDTOs = new ArrayList<ResponseSizeDTO>();

		for (SizeEntity sizeEntity : entities) {
			ResponseSizeDTO sizeDTO = new ResponseSizeDTO();

			sizeDTO.setId(sizeEntity.getId());
			sizeDTO.setCode(sizeEntity.getCode());
			sizeDTO.setDescription(sizeEntity.getDescription());

			responseSizeDTOs.add(sizeDTO);
		}

		return responseSizeDTOs;
	}

	@Override
	public void createSize(RequestSizeDTO requestSizeDTO) {
		SizeEntity sizeEntity = new SizeEntity();

		sizeEntity.setCode(requestSizeDTO.getCode());
		sizeEntity.setDescription(requestSizeDTO.getDescription());
		sizeEntity.setStatus(StatusSizeEnum.A);

		sizeRepository.save(sizeEntity);
	}

}

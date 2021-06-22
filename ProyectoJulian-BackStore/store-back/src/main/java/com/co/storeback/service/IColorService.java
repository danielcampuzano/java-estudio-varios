package com.co.storeback.service;

import java.util.List;

import com.co.storeback.dto.RequestNewColorDTO;
import com.co.storeback.dto.ResponseColorDTO;

public interface IColorService {

	
	List<ResponseColorDTO> findAll();
	void createColor(RequestNewColorDTO colorDTO);
	
}

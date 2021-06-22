package com.co.storeback.service;

import java.util.List;

import com.co.storeback.dto.RequestSizeDTO;
import com.co.storeback.dto.ResponseSizeDTO;

public interface ISizeService {

	List<ResponseSizeDTO> findAll();
	void createSize(RequestSizeDTO requestSizeDTO);
	
}

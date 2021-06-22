package com.co.storeback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestSizeDTO;
import com.co.storeback.dto.ResponseDTO;
import com.co.storeback.dto.ResponseSizeDTO;
import com.co.storeback.service.ISizeService;
import com.co.storeback.util.MessageConstant;

@RestController
@RequestMapping(value = "/size")
public class SizeController {
	
	@Autowired
	private ISizeService sizeService;
	
	@Autowired
	private MessageSourceComponent messageSource;
	
	@GetMapping
	public ResponseDTO<List<ResponseSizeDTO>> findAllSize() {
		ResponseDTO<List<ResponseSizeDTO>> responseDTO = new ResponseDTO<List<ResponseSizeDTO>>();
		try {
			responseDTO.setData(sizeService.findAll());
			responseDTO.setSuccess(true);
		}catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;		
	}
	
	@PostMapping
	public ResponseDTO<String> createSize(@RequestBody @Validated RequestSizeDTO sizeDTO) {
		ResponseDTO<String> responseDTO = new ResponseDTO<String>();
		try {
			sizeService.createSize(sizeDTO);
			responseDTO.setSuccess(true);
		}catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;		
	}

}

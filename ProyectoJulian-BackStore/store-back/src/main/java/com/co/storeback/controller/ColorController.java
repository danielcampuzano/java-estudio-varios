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
import com.co.storeback.dto.RequestNewColorDTO;
import com.co.storeback.dto.ResponseColorDTO;
import com.co.storeback.dto.ResponseDTO;
import com.co.storeback.service.IColorService;
import com.co.storeback.util.MessageConstant;

@RestController
@RequestMapping(value = "/color")
public class ColorController {

	@Autowired
	private IColorService colorService;
	
	@Autowired
	private MessageSourceComponent messageSource;
	
	@GetMapping
	public ResponseDTO<List<ResponseColorDTO>> findAllColors() {
		ResponseDTO<List<ResponseColorDTO>> responseDTO = new ResponseDTO<List<ResponseColorDTO>>();
		try {
			responseDTO.setData(colorService.findAll());
			responseDTO.setSuccess(true);
		}catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;		
	}
	
	@PostMapping
	public ResponseDTO<String> createColor(@RequestBody @Validated RequestNewColorDTO colorDTO) {
		ResponseDTO<String> responseDTO = new ResponseDTO<String>();
		try {
			colorService.createColor(colorDTO);
			responseDTO.setSuccess(true);
		}catch (Exception e) {
			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}
		return responseDTO;		
	}
	
}

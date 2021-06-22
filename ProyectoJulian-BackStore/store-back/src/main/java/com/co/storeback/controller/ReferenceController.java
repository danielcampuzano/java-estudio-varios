/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.storeback.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.storeback.component.MessageSourceComponent;
import com.co.storeback.dto.RequestPriceDTO;
import com.co.storeback.dto.RequestSearchReferencesDTO;
import com.co.storeback.dto.ResponseDTO;
import com.co.storeback.dto.ResponseSearchReferencesDTO;
import com.co.storeback.exception.BusinessStoreException;
import com.co.storeback.service.IReferenceService;
import com.co.storeback.util.MessageConstant;

/**
 *
 * @author user
 */
@RestController
@RequestMapping(path = "/reference")
public class ReferenceController {

	@Autowired
	private IReferenceService referenceService;

	@Autowired
	private MessageSourceComponent messageSource;

	@Value("${store.pagination.limit.default}")
	private Integer defaultLimit;

	@Value("${store.pagination.page.default}")
	private Integer defaultPage;

	@GetMapping
	public ResponseDTO<List<ResponseSearchReferencesDTO>> getRefences(
			@RequestParam(value = "name") Optional<String> name,
			@RequestParam(value = "category") Optional<Integer> category,
			@RequestParam(value = "limit") Optional<Integer> limit,
			@RequestParam(value = "page") Optional<Integer> page) {

		ResponseDTO<List<ResponseSearchReferencesDTO>> responseDTO = new ResponseDTO<List<ResponseSearchReferencesDTO>>();

		try {
			RequestSearchReferencesDTO searchReferencesDTO = new RequestSearchReferencesDTO();

			searchReferencesDTO.setName(name.isPresent() ? name.get() : null);
			searchReferencesDTO.setCategory(category.isPresent() ? category.get() : null);
			searchReferencesDTO.setPage(page.isPresent() ? page.get() : defaultPage);
			searchReferencesDTO.setLimit(limit.isPresent() ? limit.get() : defaultLimit);

			responseDTO.setData(referenceService.searchReferences(searchReferencesDTO, false));

			if (name.isPresent() && responseDTO.getData() != null) {
				referenceService.updateSearchQuanty(
						responseDTO.getData().stream().map(x -> x.getId()).collect(Collectors.toList()));
			}

			responseDTO.setSuccess(true);
		} catch (Exception e) {

			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}

		return responseDTO;
	}

	@GetMapping(path = "/{idReference}")
	public ResponseDTO<ResponseSearchReferencesDTO> createPrice(@PathVariable("idReference") Integer idReference) {
		ResponseDTO<ResponseSearchReferencesDTO> responseDTO = new ResponseDTO<ResponseSearchReferencesDTO>();
		try {
			responseDTO.setData(referenceService.findByReference(idReference, true));
			responseDTO.setSuccess(true);
		} catch (BusinessStoreException bse) {
			responseDTO.setMessage(bse.getMessage());
		} catch (Exception e) {

			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}

		return responseDTO;
	}

	@PutMapping(path = "/pricing/price/{idReference}")
	public ResponseDTO<String> createPrice(@PathVariable("idReference") Integer idReference,
			@RequestBody @Validated RequestPriceDTO requestPriceDTO) {
		ResponseDTO<String> responseDTO = new ResponseDTO<String>();
		try {
			referenceService.assignPrice(requestPriceDTO, idReference);
			responseDTO.setSuccess(true);
		} catch (BusinessStoreException bse) {
			responseDTO.setMessage(bse.getMessage());
		} catch (Exception e) {

			responseDTO.setMessage(messageSource.getMessage(MessageConstant.ERROR));
		}

		return responseDTO;
	}

}

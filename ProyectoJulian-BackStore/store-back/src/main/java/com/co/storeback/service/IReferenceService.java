package com.co.storeback.service;

import java.util.List;

import com.co.storeback.dto.RequestPriceDTO;
import com.co.storeback.dto.RequestSearchReferencesDTO;
import com.co.storeback.dto.ResponseSearchReferencesDTO;
import com.co.storeback.exception.BusinessStoreException;

public interface IReferenceService {
	
	List<ResponseSearchReferencesDTO> searchReferences(RequestSearchReferencesDTO searchReferencesDTO, boolean completeData);
	ResponseSearchReferencesDTO findByReference(Integer idReference, boolean completeData) throws BusinessStoreException;
	void updateSearchQuanty(List<Integer> listIdReferences);
	void assignPrice(RequestPriceDTO requestPriceDTO, Integer idReference) throws BusinessStoreException;

}

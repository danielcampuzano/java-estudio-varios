package com.co.storeback.service;

import java.util.List;

import com.co.storeback.dto.RequestAddCartProductDTO;
import com.co.storeback.dto.ResponseCartProductDTO;
import com.co.storeback.exception.BusinessStoreException;

public interface ICartService {

	List<ResponseCartProductDTO> addCartProducts(String identifier, RequestAddCartProductDTO cartProductDTO) throws BusinessStoreException;
	List<ResponseCartProductDTO> findCartProducts(String identifier);
}

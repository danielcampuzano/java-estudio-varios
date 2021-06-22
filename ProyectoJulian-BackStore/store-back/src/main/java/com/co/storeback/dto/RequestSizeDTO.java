package com.co.storeback.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequestSizeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "El código de la talla no está presente")
	@NotEmpty(message = "El código de la talla no está presente")
	private String code;
	@NotNull(message = "El nombre de la talla no está presente")
	@NotEmpty(message = "El nombre de la talla no está presente")
	private String description;
	
	public RequestSizeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}

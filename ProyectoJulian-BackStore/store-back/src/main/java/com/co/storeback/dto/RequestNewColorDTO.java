package com.co.storeback.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequestNewColorDTO {

	@NotNull(message = "El nombre del color no está presente")
	@NotEmpty(message = "El nombre del color no está presente")
	private String code;
	@NotNull(message = "El nombre del color no está presente")
	@NotEmpty(message = "El nombre del color talla no está presente")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

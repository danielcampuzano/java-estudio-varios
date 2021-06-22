package com.co.storeback.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.co.storeback.enums.StatusCategoryEnum;

public class RequestNewCategoryDTO {
	
	@NotNull(message = "El nombre de la categoría no está presente")
	@NotEmpty(message = "El nombre de la categoría no está presente")
	private String name;
	@NotNull(message = "El estado de la categoría no está presente")
	private StatusCategoryEnum status;
	private Integer idRootCategory;
	
	public RequestNewCategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public StatusCategoryEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusCategoryEnum status) {
		this.status = status;
	}

	public Integer getIdRootCategory() {
		return idRootCategory;
	}
	
	public void setIdRootCategory(Integer idRootCategory) {
		this.idRootCategory = idRootCategory;
	}
	
}

package com.co.storeback.dto;

import java.io.Serializable;

public class ResponseCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private ResponseCategoryDTO category;
	
	public ResponseCategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ResponseCategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(ResponseCategoryDTO category) {
		this.category = category;
	}

}

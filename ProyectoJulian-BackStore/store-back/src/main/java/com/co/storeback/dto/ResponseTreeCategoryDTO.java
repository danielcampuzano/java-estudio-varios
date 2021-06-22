package com.co.storeback.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseTreeCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<ResponseTreeCategoryDTO> categories;
	
	public ResponseTreeCategoryDTO() {
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

	public List<ResponseTreeCategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<ResponseTreeCategoryDTO> categories) {
		this.categories = categories;
	}
	
	
}

package com.co.storeback.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseSearchReferencesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5461474761428330740L;
	private int id;
	private String name;
	private String description;
	private ResponseCategoryDTO category;
	private ResponsePriceDTO price;
	private List<ResponseColorDTO> color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public ResponsePriceDTO getPrice() {
		return price;
	}
	
	public void setPrice(ResponsePriceDTO price) {
		this.price = price;
	}

	public ResponseCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(ResponseCategoryDTO category) {
		this.category = category;
	}

	public List<ResponseColorDTO> getColor() {
		return color;
	}
	
	public void setColor(List<ResponseColorDTO> color) {
		this.color = color;
	}
	
}

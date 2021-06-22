package com.co.storeback.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseColorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1511497181494673190L;
	private Integer id;
	private String code;
	private String name;
	private List<ResponseProductDto> products;
	private String[] image;
	

	public ResponseColorDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<ResponseProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ResponseProductDto> products) {
		this.products = products;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}

}

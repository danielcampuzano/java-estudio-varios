package com.co.storeback.dto;

import java.io.Serializable;

public class ResponseProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String ean;
	private String talla;
	
	public ResponseProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEan(String ean) {
		this.ean = ean;
	}
	
	public String getEan() {
		return ean;
	}
	
	public String getTalla() {
		return talla;
	}
	
	public void setTalla(String talla) {
		this.talla = talla;
	}

}

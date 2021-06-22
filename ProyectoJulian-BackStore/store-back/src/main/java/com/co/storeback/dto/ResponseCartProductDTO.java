package com.co.storeback.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResponseCartProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5865693425547503815L;
	private Integer idProduct;
	private String size;
	private String color;
	private String nameProduct;
	private Integer quantity;
	private ResponsePriceDTO priceUnit;
	private BigDecimal total;
	private String[] image;

	public ResponseCartProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ResponsePriceDTO getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(ResponsePriceDTO priceUnit) {
		this.priceUnit = priceUnit;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}
}

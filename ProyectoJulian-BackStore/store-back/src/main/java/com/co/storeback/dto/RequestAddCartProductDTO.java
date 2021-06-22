package com.co.storeback.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequestAddCartProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 170942865557628513L;
	@NotEmpty(message = "El id del producto para agregar, no está definido")
	private Integer idProduct;
	@NotNull(message = "El nombre del producto para agregar, no está definido")
	@NotEmpty(message = "El nombre del producto para agregar, no está definido")
	private String productName;
	@NotEmpty(message = "La cantidad del producto para agregar, no está definido")
	private Integer quantity;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

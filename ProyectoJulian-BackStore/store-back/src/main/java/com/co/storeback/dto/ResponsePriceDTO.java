package com.co.storeback.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResponsePriceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private BigDecimal discountPer;
	
	public ResponsePriceDTO() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(BigDecimal discountPer) {
		this.discountPer = discountPer;
	}
	
}

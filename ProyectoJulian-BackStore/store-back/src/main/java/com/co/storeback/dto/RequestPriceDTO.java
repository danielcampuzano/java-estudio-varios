package com.co.storeback.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class RequestPriceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "El valor del costo no está definido")
	private BigDecimal cost;
	@NotNull(message = "El porcentaje de descuento no está definido")
	private BigDecimal discountPer;
	@NotNull(message = "El descuento no está definido")
	private BigDecimal discountCost;
	@NotNull(message = "El costo total no está definido")
	private BigDecimal totalCost;
	@NotNull(message = "Fecha inicial no está definido")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date startDate;
	@NotNull(message = "Fecha final no está definido")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date endDate;

	public RequestPriceDTO() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(BigDecimal discountPer) {
		this.discountPer = discountPer;
	}

	public BigDecimal getDiscountCost() {
		return discountCost;
	}

	public void setDiscountCost(BigDecimal discountCost) {
		this.discountCost = discountCost;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}

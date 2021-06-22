package com.co.storeback.enums;

public enum StatusPriceEnum {

	A("A"), I("A");

	private String status;

	StatusPriceEnum(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static StatusPriceEnum from(String id) {
		StatusPriceEnum priceEnum = null;
		for (StatusPriceEnum item : StatusPriceEnum.values()) {
			if (item.getValue() == id) {
				priceEnum = item;
				break;
			}
		}
		return priceEnum;
	}

}

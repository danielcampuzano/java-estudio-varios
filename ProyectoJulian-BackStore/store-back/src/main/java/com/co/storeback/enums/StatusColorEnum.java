package com.co.storeback.enums;

public enum StatusColorEnum {

	A("A"), I("A");

	private String status;

	StatusColorEnum(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static StatusColorEnum from(String id) {
		StatusColorEnum colorEnum = null;
		for (StatusColorEnum item : StatusColorEnum.values()) {
			if (item.getValue() == id) {
				colorEnum = item;
				break;
			}
		}
		return colorEnum;
	}

}

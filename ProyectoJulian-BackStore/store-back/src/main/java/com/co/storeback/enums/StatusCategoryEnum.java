package com.co.storeback.enums;

public enum StatusCategoryEnum {

	A("A"), I("A");

	private String status;

	StatusCategoryEnum(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static StatusCategoryEnum from(String id) {
		StatusCategoryEnum referenceEnum = null;
		for (StatusCategoryEnum item : StatusCategoryEnum.values()) {
			if (item.getValue() == id) {
				referenceEnum = item;
				break;
			}
		}
		return referenceEnum;
	}

}

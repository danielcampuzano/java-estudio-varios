package com.co.storeback.enums;

public enum StatusSizeEnum {

	A("A"), I("A");

	private String status;

	StatusSizeEnum(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static StatusSizeEnum from(String id) {
		StatusSizeEnum referenceEnum = null;
		for (StatusSizeEnum item : StatusSizeEnum.values()) {
			if (item.getValue() == id) {
				referenceEnum = item;
				break;
			}
		}
		return referenceEnum;
	}

}

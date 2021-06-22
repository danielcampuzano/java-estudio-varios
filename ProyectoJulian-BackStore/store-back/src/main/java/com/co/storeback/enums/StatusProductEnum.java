package com.co.storeback.enums;

public enum StatusProductEnum {

	A("A"), I("A");

	private String status;

	StatusProductEnum(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static StatusProductEnum from(String id) {
		StatusProductEnum referenceEnum = null;
		for (StatusProductEnum item : StatusProductEnum.values()) {
			if (item.getValue() == id) {
				referenceEnum = item;
				break;
			}
		}
		return referenceEnum;
	}

}

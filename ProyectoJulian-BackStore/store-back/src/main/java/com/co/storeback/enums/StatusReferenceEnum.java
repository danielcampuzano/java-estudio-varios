package com.co.storeback.enums;

public enum StatusReferenceEnum {

	A("A"), I("A");

	private String status;

	StatusReferenceEnum(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}

	public static StatusReferenceEnum from(String id) {
		StatusReferenceEnum referenceEnum = null;
		for (StatusReferenceEnum item : StatusReferenceEnum.values()) {
			if (item.getValue() == id) {
				referenceEnum = item;
				break;
			}
		}
		return referenceEnum;
	}

}

package com.co.storeback.enums;

public enum VisibleReferenceEnum {

	A("A"), I("I");

	private String visible;

	VisibleReferenceEnum(String visible) {
		this.visible = visible;
	}

	public String getValue() {
		return visible;
	}

	public static VisibleReferenceEnum from(String id) {
		VisibleReferenceEnum referenceEnum = null;
		for (VisibleReferenceEnum item : VisibleReferenceEnum.values()) {
			if (item.getValue() == id) {
				referenceEnum = item;
				break;
			}
		}
		return referenceEnum;
	}

}

package com.example.demo.enums;

/**
 * 接口返回状态enum
 */
public enum ResultEnum implements IEnum {

	SUCCESS(200, "成功");

	private Integer key;
	private String value;

	ResultEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}


}

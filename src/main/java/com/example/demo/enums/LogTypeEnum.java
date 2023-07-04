package com.example.demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 日志类型枚举
 *
 * @Author luoYong
 * @Date 2021-08-05 15:41
 */
public enum LogTypeEnum implements IEnum {

	LOG_TYPE_LOGIN(1, "登录日志"),
	LOG_TYPE_LOGOUT(2, "登出日志"),
	LOG_TYPE_EXPORT(3, "导出日志"),
	LOG_TYPE_QUERY(4, "查询日志"),
	LOG_TYPE_EDIT(5, "修改日志"),
	LOG_TYPE_ADD(6, "新增日志"),
	LOG_TYPE_DELETE(7, "删除日志"),
	LOG_TYPE_IMPORT(8, "导入日志"),
	LOG_TYPE_LOGIN_OUT(9, "外部日志");

	@EnumValue
	private Integer key;
	private String value;

	LogTypeEnum(Integer key, String value) {
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

	/**
	 * 将参数反序列化为枚举
	 *
	 * @param param 当前值
	 */
	@JsonCreator
	public static LogTypeEnum parse(Integer param) {
		return IEnum.parse(param, LogTypeEnum.class);
	}
}

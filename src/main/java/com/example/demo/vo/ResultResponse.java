package com.example.demo.vo;

import com.example.demo.enums.IEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 接口返回结果，带对象
 */
@ApiModel(value = "带内容的返回信息",description = "带内容的返回信息")
public class ResultResponse<T> extends BaseResponse {

	@ApiModelProperty("返回内容")
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResultResponse() {

	}

	public ResultResponse(T data) {
		this.data = data;
	}

	public ResultResponse(IEnum iEnum) {
		super(iEnum);
	}
}

package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * entity父类重写toString方法，让对象输出时为json
 */
@ApiModel(value = "实体基础信息", description = "实体基础信息")
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableField("create_time")
	@ApiModelProperty(value = "创建时间")
	protected Date createTime;

	@TableField("creator")
	@ApiModelProperty(value = "创建人")
	protected String creator;

	@TableField("update_time")
	@ApiModelProperty(value = "修改时间",name = "updateTime")
	protected Date updateTime;

	@TableField(value = "updator")
	@ApiModelProperty(value = "修改人")
	protected String updator;


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

}

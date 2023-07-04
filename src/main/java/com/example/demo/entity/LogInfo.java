package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.enums.LogTypeEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 系统日志实体
 *
 * @Author luoYong
 * @Date 2021-08-05 15:38
 */
@Data
@TableName("log_info")
@ApiModel(value = "系统日志实体", description = "系统日志实体")
public class LogInfo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id自增列")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "操作类型")
    @TableField(value = "log_type")
    private String logType;

    @ApiModelProperty(value = "接口返回状态码")
    @TableField(value = "response_code")
    private int responseCode;

    @ApiModelProperty(value = "请求时间")
    @TableField(value = "operate_time")
    private Date operateTime;

    @ApiModelProperty(value = "消耗时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @TableField(value = "spend_time")
    private Long spendTime;

    @ApiModelProperty(value = "url")
    @TableField(value = "url")
    private String url;

    @ApiModelProperty(value = "请求体")
    @TableField(value = "body")
    private String body;

    @ApiModelProperty(value = "ip")
    @TableField(value = "ip")
    private String ip;

    @ApiModelProperty(value = "查询参数")
    @TableField(value = "query")
    private String query;

    @ApiModelProperty(value = "异常信息")
    @TableField(value = "exception")
    private String exception;

    public LogInfo() {
    }

    @JsonCreator
    public LogInfo(@JsonProperty("id") int id) {
        this.id = id;
    }
}

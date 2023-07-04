package com.example.demo.component.mail.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 静态模板邮件配置
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/18 11:17
 */
@ApiModel(value = "静态模板邮件配置",description = "静态模板邮件配置")
public class ThymeleafMail extends Mail {

    @ApiModelProperty("静态文件参数配置")
    private List<Variable> variables;

    @ApiModelProperty("静态文件名+后缀")
    private String template;

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}

package com.example.demo.component.mail.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 发送带图片资源邮件参数
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/18 10:54
 */
@ApiModel(value = "发送带图片资源邮件参数",description = "发送带图片资源邮件参数")
public class ImgResMail extends Mail {

    @ApiModelProperty("对于的图片标记id")
    private List<String> contentIds;

    @ApiModelProperty("图片地址")
    private List<String> paths;

    public List<String> getContentIds() {
        return contentIds;
    }

    public void setContentIds(List<String> contentIds) {
        this.contentIds = contentIds;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}

package com.example.demo.component.mail.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * 发送带附件的邮件参数
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/18 10:57
 */
public class AccessoryMail extends Mail {

    @ApiModelProperty("附件地址")
    private String attachmentPath;

    @ApiModelProperty("附件名")
    private String attachmentName;

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

}

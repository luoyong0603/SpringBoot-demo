package com.example.demo.component.mail.build;

import com.example.demo.component.mail.model.AccessoryMail;
import com.example.demo.component.mail.model.ImgResMail;
import com.example.demo.component.mail.model.Mail;
import com.example.demo.component.mail.model.ThymeleafMail;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/1/18 9:36
 */
//@Component
public class SendMailBuild {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;    //创建模板引擎
    @Autowired
    private UserService userService;


    /**
     * 发送简单邮件
     */
    public void sendSimpleMail(Mail model) {
        //构建邮件内容对象
        SimpleMailMessage msg = new SimpleMailMessage();
        //邮件发送者
        msg.setFrom(model.getSendMailAccount());
        //邮件接收者
        msg.setTo(model.getAcceptMailAccount());
        //邮件主题
        msg.setSubject(model.getTheme());
        //邮件正文
        msg.setText(model.getMailText());
        //邮件发送时间
        msg.setSentDate(model.getSendTime());
        javaMailSender.send(msg);
    }

    /**
     * 发送带附件的邮件
     */
    public void sendAccessoryMail(AccessoryMail model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        //邮件发送者
        msg.setFrom(model.getSendMailAccount());
        //邮件接收者
        msg.setTo(model.getAcceptMailAccount());
        //邮件主题
        msg.setSubject(model.getTheme());
        //邮件正文
        msg.setText(model.getMailText());
        //邮件发送时间
        msg.setSentDate(model.getSendTime());
        //添加附件
        msg.addAttachment(model.getAttachmentName(), new File(model.getAttachmentPath()));
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送带图片资源的邮件
     * 图片资源和附件的区别就在于：图片资源是放在邮件正文中的，就是一打开邮件就能看到图片。
     */
    public void sendImgResMail(ImgResMail model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        //邮件发送者
        msg.setFrom(model.getSendMailAccount());
        //邮件接收者
        msg.setTo(model.getAcceptMailAccount());
        //邮件主题
        msg.setSubject(model.getTheme());
        //邮件发送时间
        msg.setSentDate(model.getSendTime());
        //邮件正文
        msg.setText(model.getMailText(),true);
        //添加图片链接
        for (int i = 0; i < model.getContentIds().size(); i++) {
            msg.addInline(model.getContentIds().get(i), new FileSystemResource(new File(model.getPaths().get(i))));
        }
        javaMailSender.send(mimeMessage);
    }

    /**
     * 配置静态模板 这里使用了Thymeleaf 用作邮件模板
     */
    public void sendThymeleafMail(ThymeleafMail model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
        //邮件发送者
        msg.setFrom(model.getSendMailAccount());
        //邮件接收者
        msg.setTo(model.getAcceptMailAccount());
        //邮件主题
        msg.setSubject(model.getTheme());
        //邮件发送时间
        msg.setSentDate(model.getSendTime());
        Context context = new Context();
        //添加模板数据
        model.getVariables().forEach(p -> {
            context.setVariable(p.getName(), p.getValue());
        });
        //指定静态页面模板
        String process = templateEngine.process(model.getTemplate(), context);
        msg.setText(process, true);
        javaMailSender.send(mimeMessage);
    }

}

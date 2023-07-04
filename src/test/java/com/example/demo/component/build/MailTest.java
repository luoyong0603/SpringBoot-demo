package com.example.demo.component.build;

import com.example.demo.component.mail.build.SendMailBuild;
import com.example.demo.component.mail.model.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MailTest {

    @Autowired
    private SendMailBuild sendMailBuild;


    /**
     * 发送简单邮件
     */
    @Test
     void sendSimpleMail() {
        Mail mailModel = new Mail();
        mailModel.setTheme("title：这是一封测试邮件哈！"); // 设置邮件主题
        mailModel.setSendMailAccount("luoyong0603@foxmail.com"); // 设置邮箱发送者
        mailModel.setAcceptMailAccount("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        mailModel.setSendTime(new Date());    // 设置邮件发送日期
        mailModel.setMailText("text：这是测试邮件的正文内容：我是testMail");   // 设置邮件的正文
        sendMailBuild.sendSimpleMail(mailModel);
    }


    /**
     * 发送带附件的邮件
     */
    @Test
    void sendSimpleMailForDoc() throws MessagingException {
        AccessoryMail mailModel = new AccessoryMail();
        mailModel.setTheme("这是一封测试邮件"); // 设置邮件主题
        mailModel.setSendMailAccount("luoyong0603@foxmail.com"); // 设置邮箱发送者
        mailModel.setAcceptMailAccount("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        mailModel.setSendTime(new Date());    // 设置邮件发送日期
        mailModel.setMailText("这是测试邮件的正文");   // 设置邮件的正文
        mailModel.setAttachmentName("2022.png");//附件名
        mailModel.setAttachmentPath("C:\\Users\\Administrator\\Desktop\\2022.png");//附件地址
        sendMailBuild.sendAccessoryMail(mailModel);
    }

    /**
     * 发送带图片资源的邮件
     * 图片资源和附件的区别就在于 图片资源是放在邮件正文中的，就是一打开邮件就能看到图片
     */
    @Test
    public void sendImgResMail() throws MessagingException {
        ImgResMail mailModel = new ImgResMail();
        mailModel.setTheme("这是一封测试邮件"); // 设置邮件主题
        mailModel.setSendMailAccount("luoyong0603@foxmail.com"); // 设置邮箱发送者
        mailModel.setAcceptMailAccount("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        mailModel.setSendTime(new Date());    // 设置邮件发送日期
        mailModel.setMailText("<p>hello 大家好,我是一封测试邮件,我包含了两张图片,分别如下</p><p>第一张图片：</p><img src='cid:img1'/><p>第二张图片：</p><img src='cid:img2'/>");
        List<String> paths = new ArrayList<>();
        paths.add("C:\\Users\\Administrator\\Desktop\\2022.png");
        paths.add("C:\\Users\\Administrator\\Desktop\\test.png");
        mailModel.setPaths(paths);
        List<String> contentIds = new ArrayList<>();
        contentIds.add("img1");
        contentIds.add("img2");
        mailModel.setContentIds(contentIds);
        sendMailBuild.sendImgResMail(mailModel);
    }

    /**
     * 配置静态模板 这里使用了Thymeleaf 邮件模板
     */
    @Test
    public void testSendThymeleafMail() throws MessagingException {
        ThymeleafMail mailModel = new ThymeleafMail();
        mailModel.setTheme("这是一封测试邮件"); // 设置邮件主题
        mailModel.setSendMailAccount("luoyong0603@foxmail.com"); // 设置邮箱发送者
        mailModel.setAcceptMailAccount("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        mailModel.setSendTime(new Date());    // 设置邮件发送日期
        List<Variable> variables = new ArrayList<>();
        Variable variable1 = new Variable();
        variable1.setName("school");
        variable1.setValue("清华附属小学");
        Variable variable2 = new Variable();
        variable2.setName("className");
        variable2.setValue("六(1)班");
        Variable variable3 = new Variable();
        variable3.setName("name");
        variable3.setValue("小罗");

        variables.add(variable1);
        variables.add(variable2);
        variables.add(variable3);
        mailModel.setVariables(variables);
        mailModel.setTemplate("mail.html");
        sendMailBuild.sendThymeleafMail(mailModel);
    }




}


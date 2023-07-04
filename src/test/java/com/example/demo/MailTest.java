package com.example.demo;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MailTest {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine; //创建模板引擎
    @Autowired
    private UserService userService;


    /**
     * 发送简单邮件
     */
    @Test
     void sendSimpleMail() {
        SimpleMailMessage msg = new SimpleMailMessage();    //构建一个邮件对象
        msg.setSubject("这是一封测试邮件"); // 设置邮件主题
        msg.setFrom("luoyong0603@foxmail.com"); // 设置邮箱发送者
        msg.setTo("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        msg.setTo("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        msg.setSentDate(new Date());    // 设置邮件发送日期
        msg.setText("这是测试邮件的正文");   // 设置邮件的正文
        javaMailSender.send(msg);
    }


    /**
     * 发送带附件的邮件
     */
    @Test
    void sendSimpleMailForDoc() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage,true);
        msg.setSubject("这是一封测试邮件"); // 设置邮件主题
        msg.setFrom("luoyong0603@foxmail.com"); // 设置邮箱发送者
        msg.setTo("luoyong0603@foxmail.com"); // 设置邮件接收者，可以有多个接收者
        msg.setSentDate(new Date());    // 设置邮件发送日期
        msg.setText("这是测试邮件的正文");   // 设置邮件的正文
        msg.addAttachment("2022.png",new File("C:\\Users\\Administrator\\Desktop\\2022.png"));
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送带图片资源的邮件
     * 图片资源和附件的区别就在于 图片资源是放在邮件正文中的，就是一打开邮件就能看到图片
     */
    @Test
    public void sendImgResMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("luoyong0603@foxmail.com");
        helper.setTo("luoyong0603@foxmail.com");
        helper.setSentDate(new Date());
        helper.setText("<p>hello 大家好,我是一封测试邮件,我包含了两张图片,分别如下</p><p>第一张图片：</p><img src='cid:p01'/><p>第二张图片：</p><img src='cid:p02'/>",true);
        helper.addInline("p01",new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\2022.png")));
        helper.addInline("p02",new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\test.png")));
        javaMailSender.send(mimeMessage);
    }

    /**
     *  配置静态模板 这里使用了Thymeleaf 邮件模板
     * @throws MessagingException
     */
    @Test
    public void sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("luoyong0603@foxmail.com");
        helper.setTo("luoyong0603@foxmail.com");
        helper.setSentDate(new Date());
        Context context = new Context();
        //添加模板数据
        context.setVariable("school","清华附属小学");
        context.setVariable("className","六(1)班");
        context.setVariable("name","小罗");
        //指定模板文件
        String process = templateEngine.process("mail.html",context);
        helper.setText(process,true);
        javaMailSender.send(mimeMessage);
    }

    /**
     *  配置自定义静态模板 并渲染数据库数据
     * @throws MessagingException
     */
    @Test
    public void sendThymeleafMailByData() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("luoyong0603@foxmail.com");
        helper.setTo("luoyong0603@foxmail.com");
        helper.setSentDate(new Date());
        Context context = new Context();
        //获取数据库数据
        List<UserEntity> users = userService.getUsers1();
        //添加模板数据
        context.setVariable("users",users);
        //指定模板文件
        String process = templateEngine.process("user.html",context);
        helper.setText(process,true);
        javaMailSender.send(mimeMessage);
    }



}


package com.test.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * https://developer.aliyun.com/article/1556614
 * @ClassName: JavaMailUntil
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/10/14 09:30
 * @Version: 1.0
 */
public class JavaMailUntil {

    public static Session createSession() {

        // 邮件服务器配置
        String host = "smtp.163.com";
        final String user = "qinfajia@163.com"; // 发件人邮箱
        final String password = "Qin780428"; // 发件人密码
        // 收件人邮箱
        //String to = "recipient-email@example.com";
        // 配置属性
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.enable", true);
        // 获取默认session对象
        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }
}

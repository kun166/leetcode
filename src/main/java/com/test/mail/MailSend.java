package com.test.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @ClassName: MailSend
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/10/14 09:34
 * @Version: 1.0
 */
public class MailSend {

    public static void main(String[] args) {
        send("qinfajia@163.com", "/Users/qinfajia/code/upload.txt", "upload.txt");
    }

    public static boolean send(String to, String filePath, String filename) {
        // 收件人邮箱
        //String to = "friendsabc6666@163.com,qinfajia@163.com";
        final String user = "qinfajia@163.com"; // 发件人邮箱

        // 获取默认session对象
        Session session = JavaMailUntil.createSession();
        try {
            // 创建邮件对象
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("2024年学平险保单，请查收");
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("学平险保单，请查收，本校学平险服务人员潘经理13780679193（微信同号）。");
            // 创建多部分
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // 第二部分是附件
            messageBodyPart = new MimeBodyPart();
            //String filePath = "/Users/qinfajia/code/upload.txt";
            //String filename = "upload.txt";

            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            // 设置完整消息
            message.setContent(multipart);
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }

    }
}

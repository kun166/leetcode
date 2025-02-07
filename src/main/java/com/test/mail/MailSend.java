package com.test.mail;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: MailSend
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/10/14 09:34
 * @Version: 1.0
 */
@Slf4j
public class MailSend {

    public static void main(String[] args) {
        // send("qinfajia@163.com", "/Users/qinfajia/code/upload.txt", "upload.txt");
        // log.info(JSON.toJSONString(initPersion()));
        //log.info(JSON.toJSONString(initMail()));
        List<Person> personList = initPerson();
        personList.sort(Comparator.comparing(o -> o.index));

        Map<Integer, String> mailMap = initMail();
        // 获取默认session对象
        Session session = JavaMailUntil.createSession();
        for (Person person : personList) {
            if (mailMap.containsKey(person.index)) {
                send(person.email, mailMap.get(person.index), person.policyHolder, person.student, session);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static boolean send(String to, String filePath, String policyHolder, String student, Session session) {
        // 收件人邮箱
        //String to = "friendsabc6666@163.com,qinfajia@163.com";
        to = to.trim();

//        if (true) {
//            log.info("to:{},filePath:{},policyHolder:{},student:{}", to, filePath, policyHolder, student);
//            return true;
//        }

        // 发件人邮箱
        final String user = "3393433534@qq.com";

        try {
            // 创建邮件对象
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("2024年学平险保单，请查收");
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();
            String text = "尊敬的" + policyHolder + "先生/女士:\r\n";
            text += "    您好！\r\n";
            text += "    您的孩子" + student + "已经参加2024年学平险，保单已经生成，请查收。\r\n";
            text += "    如有任何问题，请联系本校学平险服务人员潘经理13780679193（微信同号）。\r\n";
            text += "    感谢您的支持！\r\n";
            messageBodyPart.setText(text);
            // 创建多部分
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // 第二部分是附件
            messageBodyPart = new MimeBodyPart();

            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filePath.substring(filePath.lastIndexOf(File.separator)));
            multipart.addBodyPart(messageBodyPart);
            // 设置完整消息
            message.setContent(multipart);
            // 发送邮件
            Transport.send(message);
            log.info("to:{},filePath:{},policyHolder:{},student:{}", to, filePath, policyHolder, student);
            return true;
        } catch (MessagingException e) {
            log.error("邮件:{},保险人:{}发送失败", to, policyHolder, e);
            return false;
        }

    }

    public static List<Person> initPerson() {
        List list = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/qinfajia/code/upload.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (StringUtils.isNoneBlank(line)) {
                    String[] split = line.split("\t");
                    Person person = new Person();
                    person.policyHolder = split[0];
                    person.student = split[1];
                    person.index = Integer.parseInt(split[2]);
                    person.email = split[3];
                    list.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<Integer, String> initMail() {
        File file = new File("/Users/qinfajia/code/mail");
        Map<Integer, String> map = new HashMap<>();
        initMail(map, file);
        return map;
    }

    public static void initMail(Map<Integer, String> map, File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                initMail(map, f);
            }
        } else {
            String fileName = file.getName();
            if (fileName.indexOf("pdf") < 0) {
                return;
            }
            fileName = fileName.substring(fileName.lastIndexOf("_") + 1);
            map.put(Integer.parseInt(fileName.substring(0, fileName.length() - 4)), file.getAbsolutePath());
        }
    }
}

package com.test.other;

import java.io.*;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-09-17 09:53
 */
public class Test {
    public static void main(String[] args) throws Exception {
        SerializeUser();
        DeserializeUser();
    }

    //字列化
    private static void SerializeUser() throws IOException {
        User user = new User();
        user.setName("Java的架构师技术栈");
        user.setAge(24);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://template"));
        oos.writeObject(user);
        oos.close();
        System.out.println("添加了transient关键字序列化: age- " + user.getAge());
    }

    //反序列化
    private static void DeserializeUser() throws IOException, ClassNotFoundException {
        File file = new File("D://template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream((file)));
        User newUser = (User) ois.readObject();
        System.out.println("添加了transient关键字反序列化: age= " + newUser.getAge());
    }
}
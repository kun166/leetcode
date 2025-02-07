package com.test.object;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: EnumMain
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 10:38
 * @Version: 1.0
 */
public class EnumMain {

    @Test
    public void test() {
        EnumTest one = EnumTest.TEST_ONE;
        EnumTest oneCopy = cloneObject(one);
        System.out.println(one == oneCopy);
    }

    public <T> T cloneObject(T object) {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            //将对象序列化
            objectOutputStream.writeObject(object);

            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                 ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                //将字节反序列化
                return (T) objectInputStream.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

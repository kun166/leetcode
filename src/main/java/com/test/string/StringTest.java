package com.test.string;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-06 09:56
 */
@Slf4j
public class StringTest {

    @Test
    public void testIntern() {
        String str = "执行用时：\n" +
                "4 ms\n" +
                ", 在所有 Java 提交中击败了\n" +
                "100.00%\n" +
                "的用户\n" +
                "内存消耗：\n" +
                "42.2 MB\n" +
                ", 在所有 Java 提交中击败了\n" +
                "67.71%\n" +
                "的用户\n" +
                "通过测试用例：\n" +
                "60 / 60";
        System.out.println(str.replaceAll("\n", ""));
    }

    @Test
    public void test() {
        System.out.println("MultiDeduction".toUpperCase());
        System.out.println("newCustomer".toLowerCase());
    }


    @Test
    public void test2() {
        System.out.println(Thread.currentThread().getContextClassLoader().toString());
        System.out.println(JSON.toJSONString(null));
    }


    @Test
    public void test4() {
        System.out.println("123".substring(0, 1));
    }

    @Test
    public void test10() {
        String str = "建⽴过程：\n" +
                "1. client发送加密请求，⽣成并发送第1随机数\n" +
                "2. server收到请求，⽣成并返回第2随机数\n" +
                "3. server将注册在ca的公钥+ca数据证书发送给client\n" +
                "4. client⽣成第3随机数，第1+2+3随机数⽤公钥加密⽣成会话密钥发送给server\n" +
                "5. 双⽅后续通过会话密钥加解密数据（对称加密）";
        String[] arr = str.split("\n");
        for (String s : arr) {
            if (s.indexOf(".") > -1) {
                System.out.println(s.substring(s.indexOf(".") + 1).trim());
            } else {
                System.out.println(s.trim());
            }

        }
    }

    @Test
    public void test11() {
        String str = "aa";
        int index = str.lastIndexOf(".");
        System.out.println(index);
        System.out.println(str.substring(0, index));
        System.out.println(str.substring(index));

    }
}

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
                "135 ms\n" +
                ", 在所有 Java 提交中击败了\n" +
                "8.37%\n" +
                "的用户\n" +
                "内存消耗：\n" +
                "72.3 MB\n" +
                ", 在所有 Java 提交中击败了\n" +
                "5.16%\n" +
                "的用户\n" +
                "通过测试用例：\n" +
                "102 / 102";
        System.out.println(str.replaceAll("\n", ""));
    }

    @Test
    public void test() {
        System.out.println("newCustomer".toUpperCase());
        System.out.println("newCustomer".toLowerCase());
    }


    @Test
    public void test2() {
        System.out.println(JSON.toJSONString(null));
    }


    @Test
    public void test4() {
        System.out.println("123".substring(0, 0));
    }

    @Test
    public void test10() {
        String str = "123456";
        char[] array = str.toCharArray();
        array[3] = 'a';
        System.out.println(str);
    }

    private String hideIdCardNo(String idCardNo) {
        if (StringUtils.isBlank(idCardNo)) {
            return null;
        }
        if (idCardNo.length() <= 8) {
            return idCardNo;
        }
        StringBuilder builder = new StringBuilder(idCardNo.substring(0, 6));
        for (int i = 6; i < idCardNo.length() - 2; i++) {
            builder.append("*");
        }
        builder.append(idCardNo.substring(idCardNo.length() - 2));
        return builder.toString();
    }
}

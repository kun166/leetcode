package com.test.string;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.UUID;

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
                "13 ms\n" +
                ", 在所有 Java 提交中击败了\n" +
                "61.24%\n" +
                "的用户\n" +
                "内存消耗：\n" +
                "41.2 MB\n" +
                ", 在所有 Java 提交中击败了\n" +
                "55.62%\n" +
                "的用户\n" +
                "通过测试用例：\n" +
                "316 / 316";
        System.out.println(str.replaceAll("\n", ""));
    }

    @Test
    public void test() {
        System.out.println("credit".toUpperCase());
        System.out.println("CONTRACT_PREVIEW_LIST".toLowerCase());
    }


    @Test
    public void test2() {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }


    @Test
    public void test4() {
        System.out.println("123".substring(0, 0));
    }

    @Test
    public void test10() {
        String idCard = "1234567890";
        System.out.println(idCard.substring(idCard.length() - 4));
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

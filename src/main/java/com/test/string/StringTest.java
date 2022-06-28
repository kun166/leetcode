package com.test.string;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        String s = UUID.randomUUID()
                .toString()
                .replaceAll("-", "");
        System.out.println(s + ":" + s.length());
    }

    @Test
    public void test() {
        //System.out.println("YEARTOTALPREM".toUpperCase());
        String column = "tsr";
        column = column.toLowerCase();
        column = Character.toUpperCase(column.charAt(0)) + column.substring(1);
        System.out.println("bnf" + column);
        System.out.println(column.toLowerCase());
        //System.out.println("TBL_LCCONT".replaceAll("_", ".").toLowerCase());
    }

    @Test
    public void test1() {
        String s = "update_id";
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') {
                continue;
            }
            if (i > 0 && array[i - 1] == '_') {
                sb.append(Character.toUpperCase(array[i]));
            } else {
                sb.append(array[i]);
            }
        }
        System.out.println(sb.toString());
    }


    @Test
    public void test2() {
        String s = "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        BigDecimal bd = new BigDecimal("12.56");
        System.out.println(bd.toString());
        System.out.println("secretId".toUpperCase());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(LocalDate.parse("2022-01-01", df));
        System.out.println(URLDecoder.decode("2022-01-07%2000%3A00%3A00", "utf-8"));
        System.out.println(URLDecoder.decode("2022-01-07%2023%3A59%3A59", "utf-8"));
    }


    @Test
    public void test4() {
        System.out.println("123".substring(0,0));
    }


    @Test
    public void test8() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(JSON.toJSONString(list.stream().filter(t -> t == 1).collect(Collectors.toList())));

        double rate = 0.03 / 100;
        double result = 1;
        for (int i = 0; i < 1500; i++) {
            result *= (1 - rate);
        }
        System.out.println(1 - result);
    }

    @Test
    public void test9() {
        int i;
        for (i = 0; i < 100; i++) {
            if (i == 2) {
                break;
            }
        }
        System.out.println(i);
    }

    @Test
    public void test10() {
        String idCard = "1234567890";
        System.out.println(idCard.substring(idCard.length()-4));
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

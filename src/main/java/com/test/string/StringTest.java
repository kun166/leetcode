package com.test.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aa", null);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void test() {
        System.out.println("popup_bean_name_list".toUpperCase());
        System.out.println("CONTRACT_PREVIEW_LIST".toLowerCase());
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
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
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
        System.out.println("123".substring(0, 0));
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

    @Test
    public void test11() {
        // 2、跑结清的
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.MONTH, 0);
//        calendar.set(Calendar.DAY_OF_YEAR, 1);
//        calendar.add(Calendar.DAY_OF_YEAR, -1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(df.format(calendar.getTime()));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date startTime = calendar.getTime();
        System.out.println(df.format(endTime));
        System.out.println(df.format(startTime));
    }
}

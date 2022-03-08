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
        String str = "方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，\n" + "而后者实现的是运行时的多态性。重载发生在一个类中，同名的方法如果有不同\n" +
                "的参数列表（参数类型不同、参数个数不同或者二者都不同）则视为重载；重写\n" + "发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的返\n" +
                "回类型，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里\n" + "氏代换原则）。重载对返回类型没有特殊的要求。";
        System.out.println(str.replaceAll("\n", ""));
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
        System.out.println(hideIdCardNo("1234567890"));
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

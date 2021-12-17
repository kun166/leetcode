package com.test.string;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        String s = UUID.randomUUID().toString().replaceAll("-", "");
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
            if (array[i] == '_')
                continue;
            if (i > 0 && array[i - 1] == '_')
                sb.append(Character.toUpperCase(array[i]));
            else
                sb.append(array[i]);
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
        System.out.println(URLDecoder.decode("%E6%9C%B1%E6%B0%B8%E7%90%AA", "utf-8"));
        System.out.println(URLDecoder.decode("秦发家", "utf-8"));
//        System.out.println(File.separator);
//        System.out.println(File.pathSeparator);
//        String[] array = "test.txt".split("\\.");
//        for (String s : array) {
//            System.out.println(s);
//        }
    }


    @Test
    public void test4() {
        String str = "方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，\n" +
                "而后者实现的是运行时的多态性。重载发生在一个类中，同名的方法如果有不同\n" +
                "的参数列表（参数类型不同、参数个数不同或者二者都不同）则视为重载；重写\n" +
                "发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的返\n" +
                "回类型，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里\n" +
                "氏代换原则）。重载对返回类型没有特殊的要求。";
        System.out.println(str.replaceAll("\n", ""));
    }


    @Test
    public void test5() {
        String[] strArray = {"sms_name", "sms_code", "sms_type", "sms_tpl_params",
                "sms_tpl_id", "sms_tpl_pwd", "sms_tpl_content", "sms_tpl_type"};
        for (String str : strArray) {
            StringBuilder builder = new StringBuilder();
            boolean isUnderLine = false;
            for (char c : str.toCharArray()) {
                if (c == '_') {
                    isUnderLine = true;
                } else {
                    if (isUnderLine) {
                        builder.append(Character.toUpperCase(c));
                        isUnderLine = false;
                    } else {
                        builder.append(c);
                    }
                }
            }
            System.out.println(str + " as " + builder.toString());
        }

    }

    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add(null);
        for (int i = 0; i < 10; i++) {
            list.add("column" + i);
        }
        list.add(null);
        Collections.sort(list, (s1, s2) -> {
            if (s1 != null && s2 != null) {
                return s1.compareTo(s2);
            }
            if (s1 == null) {
                return 1;
            }
            return -1;
        });
        String ss = JSON.toJSONString(list);
        list = JSON.parseArray(ss, String.class);
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test7() {
        String str = "select t.id,t.insured_id,t.card_no,t.policy_no," +
                "t.pay_amount,t.pay_status,t.remark,t.pay_time,t.business_license_url," +
                "t.back_insured_type,t.insured_company,t.create_time,t.password122,t.account_name," +
                "t.bank_name,t.bank_branch,t.bank_sort_oneId,t.bank_sort_twoId," +
                "t.bank_code,t.card_front_url,t.card_back_url,t.apply_url,t.aid_url,t.auth_url," +
                "t.pay_pic_url,t.update_time,t.jx_id,t1.jx_name,t1.bd_name,t2.name,t2.mobile," +
                "t.exam_province,t.exam_city,t3.payTime,t4.premium,t.baosi_oper_time,t4.product_name " +
                "from (select * from `t_jx_insurance_back_insured` ";
        System.out.println(str);
    }

    @Test
    public void test8() {
        String str = "Order_Facade_Platform_lock";
        log.info(str.toUpperCase());
        log.info(str.toLowerCase());
    }


}

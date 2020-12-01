package com.test.string;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-06 09:56
 */
public class StringTest {

    @Test
    public void testIntern() {
        String s = new String("test");
        System.out.println(s.intern() == "test");
    }

    @Test
    public void test() {
        System.out.println("repetition".toUpperCase());
        System.out.println("Exchange_Coupon".toLowerCase());
        System.out.println("ELECTRONIC_INSURANCE_CLIENT_ID".replaceAll("_", ".").toLowerCase());
    }

    @Test
    public void test1() {
        int i = 1;
        i *= 2 + 1;
        System.out.println(i);
    }

    @Test
    public void test2() {
        System.out.println("What   must   be".length());
    }


    @Test
    public void test3() {
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" insert into exchange_coupon(coupon_code,coupon_value,coupon_description,coupon_name,coupon_exchange_code) ");
            sb.append(" values('HMB-30','30','30元优惠券','清洁券','CBA");
            sb.append(i);
            sb.append("') ;");
            System.out.println(sb.toString());
        }
    }

    @Test
    public void test4() {
        StringBuilder sb = new StringBuilder();
        sb.append("/abc");
        sb.lastIndexOf("/");
        sb.delete(sb.lastIndexOf("/"), sb.length() - 1);
        System.out.println(sb.toString());
    }

    @Test
    public void test5() {
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
}

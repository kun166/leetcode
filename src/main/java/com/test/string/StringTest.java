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
        System.out.println("Exchange_Coupon".toUpperCase());
        System.out.println("Exchange_Coupon".toLowerCase());
        System.out.println("ELECTRONIC_INSURANCE_CLIENT_ID".replaceAll("_", ".").toLowerCase());
    }
}

package com.test.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-10 10:46
 */
public class DateTest {

    @Test
    public void test1() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -41);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(calendar.getTime()));
    }

    @Test
    public void test2() {
        Date date = new Date(1628493306178L);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
    }

    @Test
    public void test3() {
        int dif = 888 - 820;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, dif);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(calendar.getTime()));
    }
}

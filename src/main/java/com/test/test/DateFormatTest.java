package com.test.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-17 15:14
 */
public class DateFormatTest {

    @Test
    public void test() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(df.format(calendar.getTime()));
//        System.out.println(df.format(new Date()));
        System.out.println(calendar.getTime().getTime() - System.currentTimeMillis());
        System.out.println(24 * 3600L * 1000);
        String[] array = "/convenientloan_scf_home/credit_success_day".split("/");
        System.out.println(array[2]);
    }

    @Test
    public void test1() throws ParseException {
        long c = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        System.out.println(c - date.getTime());
    }

    @Test
    public void test2() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(df.format(calendar.getTime()));
    }
}

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
        calendar.add(Calendar.DAY_OF_YEAR, -90);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(calendar.getTime()));
        System.out.println(df.format(new Date()));
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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        System.out.println(df.format(calendar.getTime()));
    }
}

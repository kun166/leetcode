package com.test.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.parse("2020-12-12"));
        System.out.println(df.format(new Date()));
    }
}

package com.test.date;

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
 * @create: 2021-10-15 16:41
 */
public class DateTest {

    @Test
    public void getYear() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
    }

    @Test
    public void compareYead() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2021-10-15");
        System.out.println(date.after(new Date()));
        System.out.println(date.before(new Date()));
    }
}

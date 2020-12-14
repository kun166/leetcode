package com.test.string;

import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-09 17:35
 */
public class SqlTest {

    @Test
    public void create20() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = df.parse("2020-12-04 00:00:00");

        String rootPath = SqlTest.class.getResource("/").getPath();
        //System.out.println(rootPath);
        try (BufferedReader in = new BufferedReader(
                new FileReader(rootPath + "/aa.txt"));
             PrintWriter out = new PrintWriter(rootPath + "/aa_sql.sql", "utf-8")) {
            String line;
            List<String> set = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                set.add(line);
            }
            System.out.println("共有:" + set.size() + "张券");
            for (String s : set) {
                int index = s.indexOf("\t");
                StringBuilder sql = new StringBuilder();
                sql.append(" OR ( insure_policy.customer = '");
                sql.append(s.substring(0, index).trim());
                sql.append("' AND insure_policy.create_time >= '");
                sql.append("2020-01-01 00:00:00");
                sql.append("' ) \r\n");
                out.write(sql.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create30() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = df.parse("2020-12-04 00:00:00");

        String rootPath = SqlTest.class.getResource("/").getPath();
        //System.out.println(rootPath);
        try (BufferedReader in = new BufferedReader(
                new FileReader(rootPath + "/aa.txt"));
             PrintWriter out = new PrintWriter(rootPath + "/aaa_sql.sql", "utf-8")) {
            String line;
            List<String> set = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                set.add(line);
            }
            System.out.println("共有:" + set.size() + "张券");
            StringBuilder sql = new StringBuilder();
            for (String s : set) {
                int index = s.indexOf("\t");
                sql.append(" '");
                sql.append(s.substring(0, index).trim());
                sql.append("', \r\n");
            }
            out.write(sql.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

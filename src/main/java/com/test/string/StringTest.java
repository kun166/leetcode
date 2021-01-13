package com.test.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        StringBuilder sb = new StringBuilder();
        sb.append("第").append(1 + 2).append("行");
        System.out.println(sb.toString());
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

    @Test
    public void test6() {
        StringBuilder sb = new StringBuilder();
        sb.append("aaaa,");
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("I ");
        list.add("am ");
        list.add("Tom");
        System.out.println(String.join(",", list));
    }

    @Test
    public void test8() {
        String s = "对于 辅助 索引（ Secondary Index， 也称 非 聚集 索引）， 叶子 节点 并不 包含 行 记录 的 全部 数据。 叶子 节点 除了 包含 键值 以外， 每个 叶子 节点 中的 索引 行中 还 包含 了 一个 书签（ bookmark）。 该书 签 用来 告诉 InnoDB 存储 引擎 哪里 可以 找到 与 索引 相 对应 的 行 数据。 由于 InnoDB 存储 引擎 表 是 索引 组织 表， 因此 InnoDB 存储 引擎 的 辅助 索引 的 书签 就是 相应 行 数据 的 聚集 索引 键。" ;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}

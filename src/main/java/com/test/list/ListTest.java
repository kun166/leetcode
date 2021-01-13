package com.test.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-01-05 19:45
 */
public class ListTest {

    @Test
    public void testSubList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        list = list.subList(0, 5);
        System.out.println(String.join(",", list));
    }
}

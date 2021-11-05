package com.test.list;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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
        List<String> subList = list.subList(0, 5);
        System.out.println(String.join(",", subList));
        subList = list.subList(5, 10);
        System.out.println(String.join(",", subList));
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
//        for (int i = 1; i <= 10; i++) {
//            list.add(i);
//        }

        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == 5 || i == 6) {
                iterator.remove();
            }
        }
        System.out.println(JSON.toJSONString(list));

    }
}

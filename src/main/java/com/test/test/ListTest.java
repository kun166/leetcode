package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-05 16:28
 */
public class ListTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        List<Integer> l = list.stream().filter(t -> t > 5).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(l));
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(1);
        }
        Set<Integer> set = list.stream().collect(Collectors.toSet());

        System.out.println(JSON.toJSONString(set));
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        list.removeAll(l);
//        System.out.println(JSON.toJSONString(list));
        //System.out.println(JSON.toJSONString(l));
    }
}

package com.test.list;

import com.alibaba.fastjson.JSON;
import com.test.object.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testRemove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 5 || list.get(i) == 8) {
                list.remove(i);
                i--;
            }
        }
        for (int i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void testJSON() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person();
        p1.name = "张三";
        p1.age = 14;
        list.add(p1);

        Person p2 = new Person();
        p2.name = "李四";
        p2.age = 15;
        list.add(p2);

        System.out.println(Optional.ofNullable(list).map(bean -> JSON.toJSONString(bean)).orElse(null));
        System.out.println("[{\"divisionAccountCd\":1001,\"divisionAmt\":270.77},{\"divisionAccountCd\":1002,\"divisionAmt\":21.32}]".length());

    }
}

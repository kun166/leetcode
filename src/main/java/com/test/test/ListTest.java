package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
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

    @Test
    public void testLinkedList() {
        LinkedList<Character> list = new LinkedList<>();
        list.push('a');
        list.push('b');
        System.out.println(list.pop());
    }

    @Test
    public void sort() {
        List<IntegerObject> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new IntegerObject(i));
        }
        list.sort(Comparator.comparing(IntegerObject::getData).reversed());
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void remove() {
        List<IntegerObject> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new IntegerObject(i));
        }
        System.out.println("list:" + JSON.toJSONString(list));
        List<IntegerObject> list1 = list.stream().filter(object -> object.getData() != 5).collect(Collectors.toList());
        System.out.println("list1:" + JSON.toJSONString(list1));
        System.out.println("list:" + JSON.toJSONString(list));

        list.removeIf(object -> object.getData() != 5);
        System.out.println("list:" + JSON.toJSONString(list));

    }

    @Test
    public void test2() {
        Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        queue.add(12);
        queue.add(7);
        queue.add(10);
        //queue.add(2);
        System.out.println(JSON.toJSONString(queue));
        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    @Test
    public void test3(){
        System.out.println(ListTest.class.getSimpleName());
    }
}

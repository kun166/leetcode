package com.test.list;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-13 15:06
 */
public class LinkListTest {

    @Test
    public void testRemove() {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("123");
        ll.peek();
        System.out.println(ll.removeFirst());


    }

    @Test
    public void testQueue() {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        System.out.println(deque.poll());
    }
}

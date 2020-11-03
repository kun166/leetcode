package com.test.list;

import org.junit.Test;

import java.util.LinkedList;

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
}

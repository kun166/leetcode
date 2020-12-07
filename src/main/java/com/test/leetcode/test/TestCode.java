package com.test.leetcode.test;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 16:54
 */
public class TestCode {

    @Test
    public void test() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE == -2147483648);
    }

    @Test
    public void testBit() {
        int n = 233;
        n <<= 1;
        System.out.println(n);
    }

    @Test
    public void testInteger() {
        System.out.println(new Integer(2) == new Integer(2));
    }

    @Test
    public void test1() {
        int volume = 2 << 10; //2048
        System.out.println(volume);
        int bitNum = volume - 1; //11111111111
        System.out.println(1111111 & bitNum);
    }

    @Test
    public void convert() {
        for (String ss : new String[]{"create_time", "update_time", "is_delete"}) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ss.length(); i++) {
                if (ss.charAt(i) == '_')
                    continue;
                if (i > 0 && ss.charAt(i - 1) == '_')
                    sb.append(Character.toUpperCase(ss.charAt(i)));
                else
                    sb.append(ss.charAt(i));
            }
            System.out.println(sb.toString());
        }

    }

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
    }

    @Test
    public void textDeque() {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.pop();
    }
}

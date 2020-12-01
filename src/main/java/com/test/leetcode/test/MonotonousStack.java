package com.test.leetcode.test;

import org.junit.Test;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-18 20:02
 */
public class MonotonousStack {

    @Test
    public void test() {
        print(new int[]{10, 3, 7, 4, 12});
    }

    public void print(int[] arrray) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arrray.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arrray[i]) {
                System.out.println(stack.pop());
            }
            stack.push(arrray[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

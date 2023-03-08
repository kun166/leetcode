package com.test.leetcode.page3.chapter230.t232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230308
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/8 09:56
 * @Version: 1.0
 */
public class Solution20230308 {

    class MyQueue {
        Deque<Integer> deque1;
        Deque<Integer> deque2;

        public MyQueue() {
            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
        }

        public void push(int x) {
            deque1.push(x);
        }

        public int pop() {
            if (deque2.isEmpty()) {
                while (!deque1.isEmpty()) {
                    deque2.push(deque1.pop());
                }
            }
            return deque2.pop();
        }

        public int peek() {
            if (deque2.isEmpty()) {
                while (!deque1.isEmpty()) {
                    deque2.push(deque1.pop());
                }
            }
            return deque2.peek();
        }

        public boolean empty() {
            return deque1.isEmpty() && deque2.isEmpty();
        }
    }
}

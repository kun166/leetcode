package com.test.leetcode.page3.chapter220.t225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230301
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/1 10:29
 * @Version: 1.0
 */
public class OfficialSecond20230301 {

    class MyStack {
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

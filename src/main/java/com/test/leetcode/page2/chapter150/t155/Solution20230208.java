package com.test.leetcode.page2.chapter150.t155;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: t155
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 09:43
 * @Version: 1.0
 */
public class Solution20230208 {

    class MinStack {

        List<Integer> list;
        Deque<Integer> deque;

        public MinStack() {
            list = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public void push(int val) {
            deque.push(val);
            list.add(val);
            Collections.sort(list);
        }

        public void pop() {
            Integer val = deque.pop();
            list.remove(val);
        }

        public int top() {
            return deque.peek();
        }

        public int getMin() {
            return list.get(0);
        }
    }
}

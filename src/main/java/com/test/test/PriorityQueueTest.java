package com.test.test;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName: PriorityQueuqTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 09:32
 * @Version: 1.0
 */
public class PriorityQueueTest {

    @Test
    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.add(1);
        queue.add(7);
        queue.add(7);
        System.out.println(queue.peek());
        queue.remove(7);
        System.out.println(queue.peek());
    }
}

package com.test.string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 16:15
 */
public class QueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new LinkedList<>();
        //queue.add(1);
        //queue.poll();
        System.out.println(queue.peek());
    }
}

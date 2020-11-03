package com.test.list;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-13 15:22
 */
public class LinkedBlockingQueueTest {

    @Test
    public void test() {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    queue.put(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

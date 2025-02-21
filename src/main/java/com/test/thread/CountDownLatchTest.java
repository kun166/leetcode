package com.test.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    @Test
    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread[] array = new Thread[3];
        for (int i = 0; i < 3; i++) {
            array[i] = new Thread() {
                @Override
                public void run() {
                    System.out.println("我开始执行了");
                    countDownLatch.countDown();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我执行结束了");
                }
            };
        }
        for (Thread t : array) {
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

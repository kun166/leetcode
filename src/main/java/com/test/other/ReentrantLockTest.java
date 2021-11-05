package com.test.other;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-09-17 10:41
 */
public class ReentrantLockTest {
    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    for (int j = 0; j < 1000; j++) {
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println("count=" + count);
    }
}

package com.test.test;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-17 17:09
 */
public class ThreadTest {

    @Test
    public void test() {
        Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()), "testThread");
        t.start();
    }

    @Test
    public void testWait() throws InterruptedException {
        Object lock = new Object();
        Thread first = new Thread(() -> {
            synchronized (lock) {
                System.out.println("first 获取到锁");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("first 执行完毕");
            }
        });
        first.start();

        Thread second = new Thread(() -> {
            synchronized (lock) {
                System.out.println("second 获取到锁");
                System.out.println("second 执行完毕");
            }
        });
        second.start();
        Thread.currentThread().join();
    }
}

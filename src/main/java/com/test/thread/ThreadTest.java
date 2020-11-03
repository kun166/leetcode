package com.test.thread;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-09 20:10
 */
public class ThreadTest {


    @Test
    public void testInterrupted() {
        Thread t = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();

        t.interrupt();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWait() {
        ObjectWaitTest test = new ObjectWaitTest();
        Thread t = new Thread(() -> {
            while (true) {
                test.waitTest();
            }
        });
        t.start();

        Thread notify = new Thread(() -> {
            while (true) {
                test.notifyTest();
            }
        });
        notify.start();

        try {
            notify.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

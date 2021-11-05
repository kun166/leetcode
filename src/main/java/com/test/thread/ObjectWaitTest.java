package com.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-13 10:28
 */
public class ObjectWaitTest implements Runnable {

    public synchronized void waitTest() {
        try {
            System.out.println("-------------------------");
            System.out.println("start wait");
            this.wait();
            System.out.println("notify from wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifyTest() {
        this.notify();
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am running");
        }
    }
}

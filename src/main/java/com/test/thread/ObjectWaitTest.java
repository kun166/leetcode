package com.test.thread;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-13 10:28
 */
public class ObjectWaitTest {

    public synchronized void waitTest() {
        try {
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
}

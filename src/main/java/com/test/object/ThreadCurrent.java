package com.test.object;

import org.junit.Test;

/**
 * @ClassName: ThreadCurrent
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 11:18
 * @Version: 1.0
 */
public class ThreadCurrent {

    // private Object object = null;

    @Test
    public void test() {
        Thread t = new Thread(() -> {
            methodFirst();
        });
        t.start();
        methodSecond();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void methodFirst() {
        System.out.println("methodFirst start");
        synchronized (ThreadCurrent.class) {
            System.out.println("methodFirst execute");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("methodFirst end");
    }

    public void methodSecond() {
        System.out.println("methodSecond start");
        synchronized (ThreadCurrent.class) {
            System.out.println("methodSecond execute");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("methodSecond end");
    }
}

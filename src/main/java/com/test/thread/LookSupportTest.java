package com.test.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-14 11:01
 */
public class LookSupportTest {

    @Test
    public void park() {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("I am park!");
                LockSupport.park();
                System.out.println("I am unPark!");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(t1);
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testParkCount() {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("I am park!");
                LockSupport.park();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am unPark!");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.unpark(t1);
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void unPark() {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am park!");
            LockSupport.park();
            System.out.println("I am unPark!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am park!");
            LockSupport.park();
            System.out.println("I am unPark!");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package com.test.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

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

    @Test
    public void test() {
        Thread myThread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("执行子线程...");
            }
        };
        myThread.start();
        System.out.println("主线程...");
    }

    @Test
    public void test1() {
        FutureTask<String> ft = new FutureTask(() -> {
            System.out.println("执行了");
            return "哈哈";
        });
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(ft);
        //ft.run();
        System.out.println("主线程执行");
    }

    @Test
    public void test2() {
        FutureTask<String> ft = new FutureTask(() -> {
            System.out.println("执行了");
            return "哈哈";
        });
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(ft);
        //ft.run();
        System.out.println("主线程执行");
    }

    @Test
    public void test3() {
        ObjectWaitTest test = new ObjectWaitTest();
        Thread t = new Thread(test);
        t.start();
        test.waitTest();
    }
}

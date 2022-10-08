package com.test.thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-12 10:29
 */
public class ExecutorTest {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Test
    public void test() {
        function();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void function() {
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("新线程执行结束");
        });
        System.out.println("主线程执行结束");
    }

    @Test
    public void executor() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        ExecutorService executor = new ThreadPoolExecutor(50, 50, 60, TimeUnit.SECONDS, workQueue);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                Random r = new Random();
                try {
                    Thread.sleep(r.nextInt(10) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        while (true) {
            executor.shutdown();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(workQueue.size());
        }
    }
}

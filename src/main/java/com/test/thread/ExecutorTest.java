package com.test.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
}

package com.test.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-07-14 11:31
 */
public class FutureTest {

    @Test
    public void get() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "I have finished!";
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1: " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        try {
            System.out.println("main: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

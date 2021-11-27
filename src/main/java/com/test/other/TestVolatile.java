package com.test.other;

import java.util.Comparator;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-10-20 09:33
 */
public class TestVolatile {
    //public static int count = 0;

    /* 即使使用volatile，依旧没有达到我们期望的效果 */
    public volatile static int count = 0;

    public static void increase() {
        try {
            // 延迟10毫秒，使得结果明显
            Thread.sleep(10);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    TestVolatile.increase();
                }
            }).start();
        }
        System.out.println("期望运行结果:10000");
        System.out.println("实际运行结果:" + TestVolatile.count);
    }

}


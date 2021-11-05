package com.test.other;

import java.lang.Thread.State;

public class T17 {
    public static void main(String[] args) {
        //模拟执行任务的第一个阶段的执行
        Thread stepOne = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":第一阶段任务开始执行");
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + ":第一阶段任务执行结束");
            } catch (InterruptedException e) {
            }
        }, "firststage");
        stepOne.start();
        //模拟任务第二个阶段的执行
        Thread stepTwo = new Thread(() -> {
            while (!State.TERMINATED.equals(stepOne.getState())) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + ":我在等待第一阶段任务执行结束");
            }
            System.out.println(Thread.currentThread().getName() + ":第二阶段任务执行结束");
        }, "secondstage");
        stepTwo.start();
    }
}

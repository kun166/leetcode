package com.test.other;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-09-17 09:37
 */
public class T15 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        });
        thread.start();
        //直到线程终止,否则将会一直打印线程状态,每0毫秒打印一次while (true) {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            System.out.println("线程状态" + thread.getState());
            if (Thread.State.TERMINATED.equals(thread.getState())) {
                System.out.println("线程状态" + thread.getState());
                break;
            }
        }
    }
}
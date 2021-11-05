package com.test.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-09-17 15:27
 */
public class SyncCache {
    //缓冲区
    private String[] data = new String[10];
    //缓冲区数组索引
    private int index;
    //创建一个锁
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产数据的方法
    public void product(String productData) {
        lock.lock();
        try {
            if (index == data.length) {
                System.out.println("缓冲区已满，生产者被阻塞");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data[index++] = productData;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    //消费数据的方法
    public String consume() {
        lock.lock();
        try {
            if (index == 0) {
                System.out.println("缓冲区已空，消费者被阻塞");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signal();
            index--;
            return data[index];
        } finally {
            lock.unlock();
        }
    }
}

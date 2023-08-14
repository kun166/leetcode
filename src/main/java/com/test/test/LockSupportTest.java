package com.test.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName: LockSupportTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/14 08:50
 * @Version: 1.0
 */
public class LockSupportTest {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + "进入线程");
            LockSupport.park();
            System.out.println("t1程运行结束");
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("t1已经启动，但是在内部进行了park");
        LockSupport.unpark(t1);
        System.out.println("LockSupport进行了 unpark");
    }
}

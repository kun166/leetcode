package com.test.object;

/**
 * @ClassName: Singleton
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/16 11:07
 * @Version: 1.0
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

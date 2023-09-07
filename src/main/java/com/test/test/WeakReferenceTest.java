package com.test.test;

import java.lang.ref.WeakReference;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-02-24 17:45
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        // 这个地方需要考虑常量池的影响
        String s = new String("123");
        WeakReference wr = new WeakReference(s);
        // s = null;
        for (int i = 0; i < 10000; i++) {
            new Object();
        }
        System.out.println(wr.get());
        System.out.println(s);
    }
}

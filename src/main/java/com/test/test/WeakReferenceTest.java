package com.test.test;

import java.lang.ref.WeakReference;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-02-24 17:45
 */
public class WeakReferenceTest {

    private byte[] data = new byte[1024 * 1024];

    public static void main(String[] args) {
        String s = "123";
        WeakReference wr = new WeakReference(s);
        s = null;
        System.out.println(wr.get());
    }
}

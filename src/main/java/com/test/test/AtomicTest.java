package com.test.test;

import sun.misc.Unsafe;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-27 18:48
 */
public class AtomicTest {

    private int age;

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (AtomicTest.class.getDeclaredField("age"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }
}

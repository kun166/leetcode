package com.test.test;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-04-13 14:42
 */
public class ObjectTest {

    static class ObjectA {
        private int age;
        private String name;
    }

    @Test
    public void test() {
        ObjectA test = null;
        if (test == null) {
            test = new ObjectA();
            test.age = 12;
            System.out.println("test is null");
        } else if (test.age == 12) {
            System.out.println("test is not null");
        }
    }
}

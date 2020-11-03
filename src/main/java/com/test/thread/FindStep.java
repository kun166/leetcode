package com.test.thread;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-20 15:40
 */
public class FindStep {

    @Test
    public void test() {
        System.out.println(findStep(99));
    }

    public int findStep(int n) {
        if (n <= 1) {
            return 1;
        }
        // 先两边乘以2
        n = n * 2;
        for (int i = 1; i < n; i++) {
            if (i * (i + 1) > n) return i;
        }
        return 0;
    }
}

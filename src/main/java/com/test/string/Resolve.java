package com.test.string;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 16:05
 */
public class Resolve {

    @Test
    public void test() {
//        int n = 4;
//        for (int i = 1; i <= n * n; i++) {
//            resolve(n, i);
//            System.out.println("----" + i);
//        }

        resolve(4, 23);
    }

    public void resolve(int n, int k) {
        // k怎么分解
        int[] a = new int[n + 1];
        int num = 1, index = 1;
        while (num < k) {
            index++;
            num *= index;
        }
        while (k > 0) {
            if (k >= num) {
                a[index] = k / num;
                k -= num * a[index];
            }
            while (num > k && k != 0) {
                num /= index;
                index--;
            }
        }
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}

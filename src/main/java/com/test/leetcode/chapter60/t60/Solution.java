package com.test.leetcode.chapter60.t60;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 15:00
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(getPermutation(5, 1));
    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] array = resolve(n, k - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(list.remove(array[i]));
        }
        return sb.toString();
    }

    /**
     * 分解K
     *
     * @param n
     * @param k
     * @return
     */
    public int[] resolve(int n, int k) {
        // k怎么分解
        int[] a = new int[n];
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
        return a;
    }
}

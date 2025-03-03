package com.test.leetcode.page1.chapter60.t60;

import org.junit.Test;

/**
 * @ClassName: Solution20250227
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 10:54
 * @Version: 1.0
 */
public class Solution20250227 {

    @Test
    public void test() {
        System.out.println(getPermutation(4, 24));
    }

    public String getPermutation(int n, int k) {
        boolean[] use = new boolean[n];
        // 从n-2位开始
        int[] array = new int[n];
        array[0] = 1;
        for (int i = 2; i <= n; i++) {
            array[i - 1] = array[i - 2] * i;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < n - 1) {
            int i = (k - 1) / array[n - 2 - index];
            builder.append(getNumber(use, i + 1));
            k = k - i * array[n - 2 - index];
            index++;
        }
        for (int i = 0; i < n; i++) {
            if (!use[i]) {
                builder.append(i + 1);
            }
        }
        return builder.toString();
    }

    /**
     * 从左到右找，第i个没用过的位置
     *
     * @param use
     * @param i
     * @return
     */
    public int getNumber(boolean[] use, int i) {
        for (int j = 0; j < use.length; j++) {
            if (!use[j]) {
                i--;
            }
            if (i == 0) {
                use[j] = true;
                return j + 1;
            }
        }
        return -1;
    }
}

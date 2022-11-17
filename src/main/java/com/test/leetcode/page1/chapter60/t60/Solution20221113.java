package com.test.leetcode.page1.chapter60.t60;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 20:56
 * @Version: 1.0
 */
public class Solution20221113 {

    @Test
    public void test() {
        System.out.println(getPermutation(2, 2));
    }

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        k = k - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] array = new int[n];
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = i * array[i - 1];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i > 0; i--) {
            if (k < array[i]) {
                ans.append(list.remove(0));
            } else {
                ans.append(list.remove(k / array[i]));
                k = k % array[i];
            }
        }
        ans.append(list.remove(0));
        return ans.toString();
    }
}

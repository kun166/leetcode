package com.test.leetcode.chapter60.t60;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 15:00
 */
public class Solution {

    public String getPermutation(int n, int k) {
        // k怎么分解
        int[] a = new int[n];
        int num = 1, index = 0;
        while (num < k) {
            num *= index + 1;
            index++;
        }
        return "";
    }
}

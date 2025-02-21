package com.test.leetcode.page6.chapter510.t517;

/**
 * @ClassName: Solution20230719
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/19 07:57
 * @Version: 1.0
 */
public class Solution20230719 {

    /**
     * 呃，这解法是不对的
     *
     * @param machines
     * @return
     */
    public int findMinMoves(int[] machines) {
        int total = 0, n = machines.length;
        for (int i : machines) {
            total += i;
        }
        if (total % n != 0) {
            return -1;
        }
        int average = total / n;
        int ans = 0;
        for (int i : machines) {
            if (i > average) {
                ans += i - average;
            }
        }
        return ans;
    }
}

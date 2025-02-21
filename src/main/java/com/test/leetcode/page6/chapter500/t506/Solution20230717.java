package com.test.leetcode.page6.chapter500.t506;

/**
 * @ClassName: Solution20230717
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/17 07:30
 * @Version: 1.0
 */
public class Solution20230717 {

    /**
     * 执行用时：164 ms, 在所有 Java 提交中击败了5.14%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了62.58%的用户
     * 通过测试用例：17 / 17
     *
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            index = 0;
            for (int j = 0; j < n; j++) {
                if (score[j] >= score[i]) {
                    index++;
                }
            }
            if (index == 1) {
                ans[i] = "Gold Medal";
            } else if (index == 2) {
                ans[i] = "Silver Medal";
            } else if (index == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = index + "";
            }
        }
        return ans;
    }
}

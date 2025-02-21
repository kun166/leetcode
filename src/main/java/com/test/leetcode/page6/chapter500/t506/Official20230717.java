package com.test.leetcode.page6.chapter500.t506;

import java.util.Arrays;

/**
 * @ClassName: Official20230717
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/17 07:39
 * @Version: 1.0
 */
public class Official20230717 {

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了60.07%的用户
     * 内存消耗：43.4 MB, 在所有 Java 提交中击败了55.04%的用户
     * 通过测试用例：17 / 17
     *
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }

}

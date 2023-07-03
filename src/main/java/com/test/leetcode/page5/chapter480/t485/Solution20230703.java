package com.test.leetcode.page5.chapter480.t485;

/**
 * @ClassName: Solution20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 15:02
 * @Version: 1.0
 */
public class Solution20230703 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了39.22%的用户
     * 通过测试用例：42 / 42
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, n = nums.length, j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                ans = Math.max(ans, j);
                j = 0;
            } else {
                j++;
            }
        }
        ans = Math.max(ans, j);
        return ans;
    }
}

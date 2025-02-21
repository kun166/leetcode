package com.test.leetcode.page6.chapter530.t532;

import java.util.Arrays;

/**
 * @ClassName: Solution20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 16:52
 * @Version: 1.0
 */
public class Solution20230810 {

    /**
     * 执行用时：225 ms, 在所有 Java 提交中击败了7.35%的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了51.18%的用户
     * 通过测试用例：60 / 60
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] - nums[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

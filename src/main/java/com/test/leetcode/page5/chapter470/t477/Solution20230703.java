package com.test.leetcode.page5.chapter470.t477;

import org.junit.Test;

/**
 * @ClassName: Solution20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 09:44
 * @Version: 1.0
 */
public class Solution20230703 {

    @Test
    public void test() {
        System.out.println(Integer.bitCount(4 ^ 14));
    }

    /**
     * 执行用时：2042 ms, 在所有 Java 提交中击败了8.68%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了45.49%的用户
     * 通过测试用例：46 / 46
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return ans;
    }
}

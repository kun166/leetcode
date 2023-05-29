package com.test.leetcode.page5.chapter410.t413;

import org.junit.Test;

/**
 * @ClassName: Solution20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 10:01
 * @Version: 1.0
 */
public class Solution20230529 {

    @Test
    public void test() {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了86.02%的用户
     * 通过测试用例：15 / 15
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, start = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] != nums[start + 1] - nums[start]) {
                ans += count(start, i - 1);
                start = i - 1;
            }
        }
        ans += count(start, n - 1);
        return ans;
    }

    public int count(int start, int end) {
        int dif = end - start - 1;
        if (dif < 1) {
            return 0;
        }
        return (dif + 1) * dif / 2;
    }
}

package com.test.leetcode.page3.chapter280.t280;

import java.util.Arrays;

/**
 * @ClassName: SolutionFirst20230330
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/30 09:16
 * @Version: 1.0
 */
public class SolutionFirst20230330 {

    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        // 先排序
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[nums.length - 1 - i];
        }
        if (nums.length % 2 == 1) {
            ans[ans.length - 1] = nums[nums.length / 2];
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }
}

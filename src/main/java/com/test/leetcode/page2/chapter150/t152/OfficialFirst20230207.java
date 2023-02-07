package com.test.leetcode.page2.chapter150.t152;

/**
 * @ClassName: OfficialFirst20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 20:45
 * @Version: 1.0
 */
public class OfficialFirst20230207 {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        maxF[0] = nums[0];
        int[] minF = new int[length];
        minF[0] = nums[0];
        //System.arraycopy(nums, 0, maxF, 0, length);
        //System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            // 当前值nums[i]如果是一个正值，它希望它之前的乘积越大越好
            // 相反,当前值nums[i]如果是一个负值，它希望它之前的乘积越小越好
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}

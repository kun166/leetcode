package com.test.leetcode.page2.chapter150.t152;

/**
 * @ClassName: OfficialSecond20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 21:03
 * @Version: 1.0
 */
public class OfficialSecond20230207 {

    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}

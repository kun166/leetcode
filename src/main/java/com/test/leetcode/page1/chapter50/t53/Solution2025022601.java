package com.test.leetcode.page1.chapter50.t53;

/**
 * @ClassName: Solution2025022601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/26 08:54
 * @Version: 1.0
 */
public class Solution2025022601 {

    /**
     * 呃呃呃呃，先自己写一个吧
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        // 1,先从左到右吧
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            sum = sum >= 0 ? sum : 0;
        }
        // 呃呃呃呃呃，下面的这个2可以省略……
        // 2,从右到左
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            sum = sum >= 0 ? sum : 0;
        }
        return ans;
    }
}

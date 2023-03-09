package com.test.leetcode.page3.chapter230.t238;

/**
 * @ClassName: Solution20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 16:36
 * @Version: 1.0
 */
public class Solution20230309 {

    public int[] productExceptSelf(int[] nums) {
        // 返回数组不计入空间，这题就简单了
        // 先通过ans存放n-1之前的乘积
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 从后向前，记录n+1之后的乘积
        int number = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= number;
            number *= nums[i];
        }
        return ans;
    }
}

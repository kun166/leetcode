package com.test.leetcode.page5.chapter410.t413;

/**
 * @ClassName: Official20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 10:24
 * @Version: 1.0
 */
public class Official20230529 {

    /**
     * 呃，官方解答确实更简洁啊
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}

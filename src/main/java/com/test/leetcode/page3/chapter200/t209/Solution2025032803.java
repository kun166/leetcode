package com.test.leetcode.page3.chapter200.t209;

import org.junit.Test;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 09:15
 * @Version: 1.0
 */
public class Solution2025032803 {

    @Test
    public void test() {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 1ms	击败99.79%
     * 56.87MB	击败45.46%
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (left < i && sum >= target) {
                    /**
                     * 这个地方用++left,绝妙……
                     *
                     * 换成left++好像真不行啊……
                     * target = 7
                     * {2,3,1,2,4,3}
                     * 输出:1
                     * 预期:2
                     *
                     *原因分析:
                     * 当i指向3的下标时候,sum=8
                     * left指向0……还能循环一次……
                     *
                     * 谨慎:以后多用++left,少用left++
                     */
                    sum -= nums[left++];
                }
                ans = Math.min(ans, i - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

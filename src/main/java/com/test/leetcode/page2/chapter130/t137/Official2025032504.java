package com.test.leetcode.page2.chapter130.t137;

/**
 * @ClassName: Official2025032503
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 10:58
 * @Version: 1.0
 */
public class Official2025032504 {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}

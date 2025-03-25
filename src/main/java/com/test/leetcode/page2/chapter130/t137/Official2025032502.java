package com.test.leetcode.page2.chapter130.t137;

/**
 * @ClassName: Official2025032502
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 10:50
 * @Version: 1.0
 */
public class Official2025032502 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}

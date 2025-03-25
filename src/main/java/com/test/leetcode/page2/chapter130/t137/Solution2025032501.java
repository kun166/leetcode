package com.test.leetcode.page2.chapter130.t137;

import org.junit.Test;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 10:33
 * @Version: 1.0
 */
public class Solution2025032501 {

    @Test
    public void test() {
        //System.out.println(singleNumber(new int[]{0, 0, 0, 3}));
        System.out.println(3 >> 32);
        System.out.println(3 >> 0);
    }

    /**
     * 4ms	击败25.87%
     * 44.37MB	击败94.19%
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        /**
         * 呃，
         * 3>>0和3>>32是一样的……
         */
        for (int i = 1; i <= 32; i++) {
            int count = 0;
            for (int number : nums) {
                if (((number >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}

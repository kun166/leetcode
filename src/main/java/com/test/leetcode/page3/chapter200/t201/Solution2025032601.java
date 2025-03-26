package com.test.leetcode.page3.chapter200.t201;

import org.junit.Test;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 10:40
 * @Version: 1.0
 */
public class Solution2025032601 {

    @Test
    public void test() {
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

    /**
     * 因为是连续数字,找规律吧
     * <p>
     * 1:1
     * 2:10
     * 3:11
     * <p>
     * 呃,先来个暴力的吧
     * <p>
     * left = 2147483646
     * right = 2147483647
     * 呃，有点小无语……
     *
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for (int i = left + 1; i <= right; i++) {
            ans &= i;
            if (ans == 0)
                return 0;
        }
        return ans;
    }
}

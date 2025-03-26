package com.test.leetcode.page3.chapter200.t201;

import org.junit.Test;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 10:40
 * @Version: 1.0
 */
public class Solution2025032603 {

    @Test
    public void test() {
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

    /**
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        int ans = left, end = right == Integer.MAX_VALUE ? right - 1 : right;
        for (int i = left + 1; i <= end; i++) {
            ans &= i;
            if (ans == 0)
                return 0;
        }
        if (right == Integer.MAX_VALUE)
            ans &= right;
        return ans;
    }
}

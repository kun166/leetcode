package com.test.leetcode.page3.chapter200.t201;

import org.junit.Test;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 10:40
 * @Version: 1.0
 */
public class Solution2025032602 {

    /**
     * 啥都别说了,暴力
     * <p>
     * 超出时间限制
     *
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        long l = left, r = right;
        int ans = left;
        for (long i = l + 1; i <= r; i++) {
            ans &= i;
            if (ans == 0)
                return 0;
        }
        return ans;
    }
}

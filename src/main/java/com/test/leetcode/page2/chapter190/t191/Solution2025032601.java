package com.test.leetcode.page2.chapter190.t191;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 08:52
 * @Version: 1.0
 */
public class Solution2025032601 {

    /**
     * 0ms	击败100.00%
     * 40.11MB	击败10.37%
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}

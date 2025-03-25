package com.test.leetcode.page2.chapter190.t190;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 18:01
 * @Version: 1.0
 */
public class Solution2025032503 {

    /**
     * 本来想用32位数组记一下,一想,岂不是多此一举么?
     * 0ms	击败100.00%
     * 41.15MB	击败22.17%
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0, index = 0;
        while (index++ < 32) {
            ans = (ans << 1) | (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}

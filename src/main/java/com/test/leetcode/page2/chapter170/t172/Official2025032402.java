package com.test.leetcode.page2.chapter170.t172;

/**
 * @ClassName: Official2025032402
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 16:13
 * @Version: 1.0
 */
public class Official2025032402 {

    /**
     * 呃
     * https://leetcode.cn/problems/factorial-trailing-zeroes/solutions/1360892/jie-cheng-hou-de-ling-by-leetcode-soluti-1egk/
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}

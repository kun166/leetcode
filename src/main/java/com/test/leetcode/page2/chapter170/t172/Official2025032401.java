package com.test.leetcode.page2.chapter170.t172;

/**
 * @ClassName: Official2025032401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 16:09
 * @Version: 1.0
 */
public class Official2025032401 {

    /**
     * n!尾零的数量即为n!中因子10的个数，而10=2×5，因此转换成求n!中质因子2的个数和质因子5的个数的较小值。
     * 由于质因子5的个数不会大于质因子2的个数，我们可以仅考虑质因子5的个数。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }
}

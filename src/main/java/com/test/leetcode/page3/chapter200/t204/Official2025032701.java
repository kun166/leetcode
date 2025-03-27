package com.test.leetcode.page3.chapter200.t204;

/**
 * @ClassName: Official2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 09:22
 * @Version: 1.0
 */
public class Official2025032701 {

    /**
     * 嗯,超出时间限制……
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

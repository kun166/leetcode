package com.test.leetcode.page3.chapter200.t204;

/**
 * @ClassName: OfficialFirst20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 09:26
 * @Version: 1.0
 */
public class OfficialFirst20230220 {

    /**
     * 枚举
     * 呃，这个和我的思路一样，结局就是超时
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

package com.test.leetcode.page3.chapter270.t279;

/**
 * @ClassName: OfficialFirst20230330
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/30 09:05
 * @Version: 1.0
 */
public class OfficialFirst20230330 {

    public int numSquares(int n) {
        // f[i] 表示最少需要多少个数的平方来表示整数 i
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            // 这个地方为什么要+1？这个1表示的是j*j。minn是最小的f[i-j*j]，加上j的平方就是f[i]了
            f[i] = minn + 1;
        }
        return f[n];
    }
}

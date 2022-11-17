package com.test.leetcode.page1.chapter60.t62;

/**
 * @ClassName: OfficialSecond20221117
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/17 19:28
 * @Version: 1.0
 */
public class OfficialSecond20221117 {

    /**
     * 这种解法真的是闻所未闻，真的是牛逼plus
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}

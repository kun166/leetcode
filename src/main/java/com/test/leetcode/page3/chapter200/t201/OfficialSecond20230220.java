package com.test.leetcode.page3.chapter200.t201;

/**
 * @ClassName: OfficialSecond20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 08:54
 * @Version: 1.0
 */
public class OfficialSecond20230220 {

    /**
     * 方法二：Brian Kernighan 算法
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}

package com.test.leetcode.page3.chapter200.t201;

/**
 * @ClassName: OfficialFirst20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 08:52
 * @Version: 1.0
 */
public class OfficialFirst20230220 {

    /**
     * 方法一：位移
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}

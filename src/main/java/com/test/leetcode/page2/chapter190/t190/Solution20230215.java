package com.test.leetcode.page2.chapter190.t190;

import org.junit.Test;

/**
 * @ClassName: Solution20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 16:28
 * @Version: 1.0
 */
public class Solution20230215 {

    @Test
    public void test() {
        System.out.println(reverseBits(-3));
    }

    /**
     * 这个颠倒2进制，和颠倒10进制，好像没什么区别？
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0, count = 32;
        while (count > 0) {
            // 先向右移动一位，把个位给新的数留下来
            ans <<= 1;
            // 这个n%2,可以被n&1替代，这个仅仅适用于二进制的时候
            ans |= (n % 2);
            n >>>= 1;
            count--;
        }
        return ans;
    }

}

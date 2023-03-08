package com.test.leetcode.page3.chapter230.t231;

import org.junit.Test;

/**
 * @ClassName: Solution20230308
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/8 09:26
 * @Version: 1.0
 */
public class Solution20230308 {

    @Test
    public void test(){
        System.out.println(isPowerOfTwo(6));
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n >= 2) {
            int m = n >> 1;
            if (n - m != m) {
                return false;
            }
            n = m;
        }
        return true;
    }
}

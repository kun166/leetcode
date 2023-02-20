package com.test.leetcode.page3.chapter200.t201;

import org.junit.Test;

/**
 * @ClassName: Solution20230217
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/17 15:01
 * @Version: 1.0
 */
public class Solution20230217 {

    @Test
    public void test() {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(Integer.MAX_VALUE);
    }

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || left == Integer.MAX_VALUE) {
            return left;
        }
        int ant = left;
        left++;
        while (left <= right) {
            ant &= left;
            if (ant == 0 || left == Integer.MAX_VALUE) {
                return ant;
            }
            left++;
        }
        return ant;
    }
}

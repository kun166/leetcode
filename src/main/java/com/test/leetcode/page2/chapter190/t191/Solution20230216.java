package com.test.leetcode.page2.chapter190.t191;

/**
 * @ClassName: Solution20230216
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/16 09:27
 * @Version: 1.0
 */
public class Solution20230216 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}

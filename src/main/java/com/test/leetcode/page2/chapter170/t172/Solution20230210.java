package com.test.leetcode.page2.chapter170.t172;

import org.junit.Test;

/**
 * @ClassName: Solution20230210
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/10 10:55
 * @Version: 1.0
 */
public class Solution20230210 {

    @Test
    public void test() {
        System.out.println(trailingZeroes(4));
        //System.out.println(25 * 25);
    }

    /**
     * 呃，这个题，我晕了，其实是能被5整除的就能生成0
     * 生成多少个0和5的阶乘有关系……
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n % 5 != 0) {
            n--;
        }
        while (n > 0) {
            count += getFiveTimes(n);
            n -= 5;
        }
        return count;
    }

    public int getFiveTimes(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                count++;
                n = n / 5;
            } else {
                return count;
            }
        }
        return count;
    }
}

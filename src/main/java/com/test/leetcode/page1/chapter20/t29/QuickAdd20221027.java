package com.test.leetcode.page1.chapter20.t29;

import org.junit.Test;

/**
 * @ClassName: QuickAdd20221027
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/27 09:59
 * @Version: 1.0
 */
public class QuickAdd20221027 {

    @Test
    public void test() {
        System.out.println(quickAdd(11, 13));
    }

    // 不用乘法，速算x*y
    public int quickAdd(int x, int y) {
        int ans = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                ans += x;
            }
            x += x;
            y >>= 1;
        }
        return ans;
    }
}

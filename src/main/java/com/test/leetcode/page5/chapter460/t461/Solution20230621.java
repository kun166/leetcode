package com.test.leetcode.page5.chapter460.t461;

import org.junit.Test;

/**
 * @ClassName: Solution20230621
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/21 16:31
 * @Version: 1.0
 */
public class Solution20230621 {

    @Test
    public void test() {
        System.out.println(32 & (32 - 1));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了69.16%的用户
     * 通过测试用例：149 / 149
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}

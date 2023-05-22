package com.test.leetcode.page4.chapter330.t338;

import org.junit.Test;

/**
 * @ClassName: Solution20230427
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/27 10:17
 * @Version: 1.0
 */
public class Solution20230427 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.91%的用户
     * 内存消耗：45.7 MB, 在所有 Java 提交中击败了18.31%的用户
     * 通过测试用例：15 / 15
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        int number = 1;
        for (int i = 2; i <= n; i++) {
            if (i == number * 2) {
                number = i;
                ans[i] = 1;
                continue;
            }
            ans[i] = ans[i - number] + 1;
        }
        return ans;
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            String s = Integer.toBinaryString(i);
            System.out.println(i + "--" + s + "--" + s.replace("0", "").length());
        }
    }
}

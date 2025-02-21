package com.test.leetcode.page4.chapter340.t342;

/**
 * @ClassName: Solution20230505
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/5 15:02
 * @Version: 1.0
 */
public class Solution20230505 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了37.89%的用户
     * 通过测试用例：1061 / 1061
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return n == 1;
    }
}

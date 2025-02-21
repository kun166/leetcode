package com.test.leetcode.page6.chapter500.t509;

/**
 * @ClassName: Solution20230718
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/18 07:28
 * @Version: 1.0
 */
public class Solution20230718 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了66.00%的用户
     * 通过测试用例：31 / 31
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int first = 0, second = 1, third;
        if (n == 0) {
            return first;
        }
        if (n == 1) {
            return second;
        }
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

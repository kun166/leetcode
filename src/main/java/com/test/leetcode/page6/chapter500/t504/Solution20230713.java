package com.test.leetcode.page6.chapter500.t504;

/**
 * @ClassName: Solution20230713
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/13 16:42
 * @Version: 1.0
 */
public class Solution20230713 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了77.98%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了44.30%的用户
     * 通过测试用例：241 / 241
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int n = Math.abs(num);
        while (n != 0) {
            builder.append(n % 7);
            n /= 7;
        }
        if (num < 0) {
            builder.append("-");
        }
        return builder.reverse().toString();
    }
}

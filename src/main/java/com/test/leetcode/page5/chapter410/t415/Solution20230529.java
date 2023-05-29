package com.test.leetcode.page5.chapter410.t415;

/**
 * @ClassName: Solution20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 11:15
 * @Version: 1.0
 */
public class Solution20230529 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了86.75%的用户
     * 通过测试用例：317 / 317
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        // 保证num1长度比num2长
        if (num1.length() < num2.length()) {
            String mid = num1;
            num1 = num2;
            num2 = mid;
        }
        int n1 = num1.length(), n2 = num2.length();
        int start = 1;
        StringBuilder builder = new StringBuilder();
        int dif = 0;
        for (; start <= n2; start++) {
            int sum = num1.charAt(n1 - start) + num2.charAt(n2 - start) - '0' - '0' + dif;
            if (sum > 9) {
                sum -= 10;
                dif = 1;
            } else {
                dif = 0;
            }
            builder.append((char) ('0' + sum));
        }
        for (; start <= n1; start++) {
            int sum = num1.charAt(n1 - start) - '0' + dif;
            if (sum > 9) {
                sum -= 10;
                dif = 1;
            } else {
                dif = 0;
            }
            builder.append((char) ('0' + sum));
        }
        if (dif == 1) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }
}

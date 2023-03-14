package com.test.leetcode.page3.chapter240.t246;

/**
 * @ClassName: Solution20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 09:10
 * @Version: 1.0
 */
public class Solution20230314 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了67.74%的用户
     *
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        StringBuilder builder = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8') {
                builder.append(num.charAt(i));
            } else if (num.charAt(i) == '6') {
                builder.append('9');
            } else if (num.charAt(i) == '9') {
                builder.append('6');
            } else {
                return false;
            }
        }
        return num.equals(builder.toString());
    }
}

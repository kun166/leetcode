package com.test.leetcode.page6.chapter520.t520;

/**
 * @ClassName: Solution20230808
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/8 16:32
 * @Version: 1.0
 */
public class Solution20230808 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了65.55%的用户
     * 通过测试用例：551 / 551
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        // 1:全大写;2:全小写;3:首字母大写
        int n = word.length();
        if (n == 1) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))) {
            // 首字母大写
            if (Character.isUpperCase(word.charAt(1))) {
                // 全部大写
                for (int i = 2; i < n; i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            } else {
                // 首字母大写
                for (int i = 2; i < n; i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
        } else {
            // 首字母小写，后面的必须全是小写
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}

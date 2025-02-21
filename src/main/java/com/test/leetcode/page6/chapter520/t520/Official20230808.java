package com.test.leetcode.page6.chapter520.t520;

/**
 * @ClassName: Official20230808
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/8 16:43
 * @Version: 1.0
 */
public class Official20230808 {

    /**
     * 这个解法感觉很不错
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}

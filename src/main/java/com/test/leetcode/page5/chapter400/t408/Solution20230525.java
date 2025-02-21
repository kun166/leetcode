package com.test.leetcode.page5.chapter400.t408;

import org.junit.Test;

/**
 * @ClassName: Solution20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 17:00
 * @Version: 1.0
 */
public class Solution20230525 {

    @Test
    public void test() {
        System.out.println(validWordAbbreviation("substitution", "s10n"));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了55.93%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * 通过测试用例：323 / 323
     *
     * @param word
     * @param abbr
     * @return
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // 先校验abbr的合法性？
        int wordLeft = 0, abbrLeft = 0;
        while (abbrLeft < abbr.length()) {
            char c = abbr.charAt(abbrLeft);
            if (Character.isDigit(c)) {
                if (c == '0') {
                    return false;
                }
                int start = abbrLeft;
                while (abbrLeft < abbr.length() && Character.isDigit(abbr.charAt(abbrLeft))) {
                    abbrLeft++;
                }
                int length = Integer.parseInt(abbr.substring(start, abbrLeft));
                if (wordLeft + length > word.length()) {
                    return false;
                }
                wordLeft += length;
            } else {
                if (wordLeft >= word.length() || c != word.charAt(wordLeft)) {
                    return false;
                }
                wordLeft++;
                abbrLeft++;
            }
        }
        return wordLeft == word.length() && abbrLeft == abbr.length();
    }
}

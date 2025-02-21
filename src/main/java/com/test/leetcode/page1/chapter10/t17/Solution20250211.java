package com.test.leetcode.page1.chapter10.t17;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 17:41
 * @Version: 1.0
 */
public class Solution20250211 {

    char[][] chars = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        letterCombinations(digits, ans, new StringBuilder(), 0);
        return ans;
    }

    public void letterCombinations(String digits, List<String> ans, StringBuilder builder, int index) {
        if (builder.length() == digits.length()) {
            ans.add(builder.toString());
            return;
        }
        for (char c : chars[digits.charAt(index) - '2']) {
            builder.append(c);
            letterCombinations(digits, ans, builder, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}

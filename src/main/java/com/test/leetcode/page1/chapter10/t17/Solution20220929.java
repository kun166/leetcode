package com.test.leetcode.page1.chapter10.t17;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20220929
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/29 17:14
 * @Version: 1.0
 */
public class Solution20220929 {

    private static Map<Character, String> map = new HashMap() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        letterCombinations(digits, ans, new StringBuilder(), 0);
        return ans;
    }

    public void letterCombinations(String digits, List<String> ans, StringBuilder stringBuilder, int index) {
        if (index == digits.length()) {
            ans.add(stringBuilder.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        for (char c : str.toCharArray()) {
            stringBuilder.append(c);
            letterCombinations(digits, ans, stringBuilder, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

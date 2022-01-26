package com.test.leetcode.page1.chapter10.t17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20220125
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/25 16:31
 * @Version: 1.0
 */
public class Solution20220125 {

    private static Map<Character, char[]> map = new HashMap<>();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int length = digits.length();
        if (length == 0) {
            return result;
        }
        letterCombinations(digits, new StringBuilder(), 0, result);
        return result;
    }

    public void letterCombinations(String digits, StringBuilder builder, int index, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(builder));
            return;
        }
        char[] chars = map.get(digits.charAt(index));
        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
            letterCombinations(digits, builder, index + 1, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}

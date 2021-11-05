package com.test.leetcode.page1.chapter10.t17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 15:30
 */
public class OfficialSolution {


    @Test
    public void test() {
        String str = "222";
        List<String> list = letterCombinations(str);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * @param combinations 用于保存结果的
     * @param phoneMap     电话号码码表
     * @param digits       原始字符串
     * @param index        新字符串长度
     * @param combination
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            // 如果新字符串长度和输入的字符串长度相等，则回溯结束，加入到combinations里
            combinations.add(combination.toString());
        } else {
            // 输入字符串的第index位的数字
            char digit = digits.charAt(index);
            // 对应的码表中的字符
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 遍历码表字符
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}

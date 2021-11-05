package com.test.leetcode.page1.chapter10.t17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-22 15:12
 */
public class Solution20201022 {

    @Test
    public void test() {
        for (String s : letterCombinations("23")) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        List<char[]> list = new ArrayList<>();
        list.add(new char[]{'a', 'b', 'c'});
        list.add(new char[]{'d', 'e', 'f'});
        list.add(new char[]{'g', 'h', 'i'});
        list.add(new char[]{'j', 'k', 'l'});
        list.add(new char[]{'m', 'n', 'o'});
        list.add(new char[]{'q', 'p', 'r', 's'});
        list.add(new char[]{'t', 'u', 'v'});
        list.add(new char[]{'w', 'x', 'y', 'z'});
        int length = digits.length();
        StringBuilder sb = new StringBuilder();
        letterCombinations(digits, result, list, sb, 0, length);
        return result;
    }

    public void letterCombinations(String digits, List<String> result, List<char[]> list, StringBuilder sb, int index, int length) {
        if (index == length) {
            result.add(sb.toString());
            return;
        }
        char[] array = list.get(digits.charAt(index) - '2');
        for (char c : array) {
            sb.append(c);
            letterCombinations(digits, result, list, sb, index + 1, length);
            sb.deleteCharAt(index);
        }
    }
    

}

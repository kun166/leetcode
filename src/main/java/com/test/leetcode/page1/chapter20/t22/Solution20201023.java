package com.test.leetcode.page1.chapter20.t22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 17:48
 */
public class Solution20201023 {

    @Test
    public void test() {
        List<String> list = generateParenthesis(2);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) return list;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(list, sb, 0, 0, n);
        return list;
    }

    public void generateParenthesis(List<String> list, StringBuilder sb, int left, int right, int n) {
        if (right == n) {
            list.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            generateParenthesis(list, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generateParenthesis(list, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

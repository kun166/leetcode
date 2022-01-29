package com.test.leetcode.page1.chapter20.t22;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20220127
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/27 11:51
 * @Version: 1.0
 */
public class Solution20220127 {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n, 0, 0, new StringBuilder(), list);
        return list;
    }

    public void generateParenthesis(int n, int left, int right, StringBuilder builder, List<String> list) {
        if (left == n && right == left) {
            list.add(builder.toString());
            return;
        }
        if (left < n) {
            builder.append("(");
            generateParenthesis(n, left + 1, right, builder, list);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            generateParenthesis(n, left, right + 1, builder, list);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}

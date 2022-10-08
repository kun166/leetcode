package com.test.leetcode.page1.chapter20.t22;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20220930
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/30 16:26
 * @Version: 1.0
 */
public class Solution20220930 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generateParenthesis(3)));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ant = new ArrayList<>();
        generateParenthesis(n, ant, new StringBuilder(), 0);
        return ant;
    }

    public void generateParenthesis(int n, List<String> ant, StringBuilder stringBuilder, int index) {
        if (stringBuilder.length() == 2 * n) {
            ant.add(stringBuilder.toString());
            return;
        }
        if (index < n) {
            stringBuilder.append('(');
            generateParenthesis(n, ant, stringBuilder, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        }
        if (stringBuilder.length() < 2 * index) {
            stringBuilder.append(')');
            generateParenthesis(n, ant, stringBuilder, index);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

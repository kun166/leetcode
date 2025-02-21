package com.test.leetcode.page1.chapter20.t22;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20250219
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 15:22
 * @Version: 1.0
 */
public class Solution20250219 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void generateParenthesis(List<String> ans, StringBuilder builder, int left, int right, int n) {
        if (left == n && right == n) {
            ans.add(builder.toString());
            return;
        }
        if (left < n) {
            // 递归,向builder中添加字符
            generateParenthesis(ans, builder.append('('), left + 1, right, n);
            // 每一次回归的时候,都把递归中添加的字符删除掉了
            builder.deleteCharAt(builder.length() - 1);
        }
        // 运行到这的时候,builder还是那个builder
        if (right < left) {
            generateParenthesis(ans, builder.append(')'), left, right + 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }
        // 运行到这里的时候，程序就退出了
    }
}

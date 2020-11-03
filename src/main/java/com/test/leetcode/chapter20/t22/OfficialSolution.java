package com.test.leetcode.chapter20.t22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 10:33
 */
public class OfficialSolution {

    @Test
    public void test() {
        List<String> list = generateParenthesisOne(1);
        System.out.println();
        for (String s : list) {
            System.out.print(s);
            System.out.print(";");
        }

        list = generateParenthesisOne(2);
        System.out.println();
        for (String s : list) {
            System.out.print(s);
            System.out.print(";");
        }

        list = generateParenthesisOne(3);
        System.out.println();
        for (String s : list) {
            System.out.print(s);
            System.out.print(";");
        }

    }

    public List<String> generateParenthesisOne(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        // 如果pos和数组长度相等，说明这个字符串已经完成了
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            // 当前数组第pos个位置为"("
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 检测左括号和右括号是否配对出现
     *
     * @param current
     * @return
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    /**
     * 官网的第二种方法。
     * 无非就是左边加括号和右边加括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisTwo(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // 字符串生成好了，就结束
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

package com.test.leetcode.page3.chapter220.t224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Official20230301
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/1 09:11
 * @Version: 1.0
 */
public class Official20230301 {


    public int calculate(String s) {
        // 记录1或者-1，记录的是当前括号前面的正负值。
        Deque<Integer> ops = new LinkedList<Integer>();
        // 默认是1，正数
        // 给当前s的最外层加上一个括号，且括号前面的符号是正数，所以不影响最终结果
        // 好处当然就是不用判空了
        ops.push(1);
        // 默认正数
        int sign = 1;
        // 返回结果
        int ret = 0;
        // 长度
        int n = s.length();
        // 起始位置
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                // 如果是空格，则继续遍历下一个字符
                i++;
            } else if (s.charAt(i) == '+') {
                // 如果当前符号是'+'，则真正的符号是ops.peek()
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                // 如果当前符号是'-',则真正的符号是ops.peek()的相反数
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                // 将括号前面的符号压入栈中
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                // 符号出栈
                ops.pop();
                i++;
            } else {
                // 是数字，计算该数字的值
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                // 计算结果
                ret += sign * num;
            }
        }
        return ret;
    }

}

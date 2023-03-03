package com.test.leetcode.page3.chapter220.t227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Official20230303
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/3 09:33
 * @Version: 1.0
 */
public class Official20230303 {

    /**
     * 这个算法感觉挺好的，只管把操作数放入堆栈中
     * <p>
     * 加号：将数字压入栈；
     * 减号：将数字的相反数压入栈；
     * 乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}

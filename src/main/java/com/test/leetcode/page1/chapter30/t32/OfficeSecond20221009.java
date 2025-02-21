package com.test.leetcode.page1.chapter30.t32;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: SolutionSecond20221009
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/9 19:32
 * @Version: 1.0
 */
public class OfficeSecond20221009 {

    @Test
    public void test() {
        System.out.println(longestValidParentheses("))))"));
    }

    /**
     * 这个算法很有意思，很不错
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 先push -1进栈是为了刚好前面的'('')'一样多，都配对了，计算长度方便
        /**
         * stack记录的是配对的那个'('之前的位置
         * 为什么不直接记录配对的那个'('的位置呢？因为解决不了"()()"这种情况
         */
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 碰到'('就压入栈中，这样就会保证碰到配对的')'的pop的时候，栈不空
                /**
                 * 初看似是压入的'('的位置，它实际上还是记录的配对之后的那个'('的前一个位置
                 * 例如"(()"
                 */
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    /**
                     * 这种情况说明多了')'，例如"())"
                     * 需要重新计算开始的位置
                     */
                    stack.push(i);
                } else {
                    // 只计算配对成功的时候的距离
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}

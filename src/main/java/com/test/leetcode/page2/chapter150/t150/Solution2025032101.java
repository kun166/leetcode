package com.test.leetcode.page2.chapter150.t150;

import java.util.LinkedList;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 09:29
 * @Version: 1.0
 */
public class Solution2025032101 {

    /**
     * 呃,这题一看就是用栈啊,先进先出……
     * <p>
     * 5ms	击败94.83%
     * 43.50MB	击败95.35%
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                ll.push(ll.pop() + ll.pop());
            } else if (str.equals("-")) {
                ll.push(-ll.pop() + ll.pop());
            } else if (str.equals("*")) {
                ll.push(ll.pop() * ll.pop());
            } else if (str.equals("/")) {
                int second = ll.pop();
                ll.push(ll.pop() / second);
            } else {
                ll.push(parseInteger(str));
            }
        }
        return ll.pop();
    }

    int parseInteger(String str) {
        int ans = 0;
        boolean minus = false;
        for (char c : str.toCharArray()) {
            if (c == '-') {
                minus = true;
            } else if (c == '+') {
                minus = false;
            } else {
                ans = ans * 10 + (c - '0');
            }
        }
        return minus ? -ans : ans;
    }

    /**
     * 好吧，这个方法第一次写错了……
     *
     * @param str
     * @return
     */
//    int parseInteger(String str) {
//        int ans = 0;
//        for (char c : str.toCharArray()) {
//            ans = ans * 10 + (c - '0');
//        }
//        return ans;
//    }
}

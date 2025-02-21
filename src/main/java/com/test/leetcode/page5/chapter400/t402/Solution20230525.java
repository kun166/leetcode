package com.test.leetcode.page5.chapter400.t402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 07:42
 * @Version: 1.0
 */
public class Solution20230525 {

    /**
     * 根据官方题解做出来的。呃，还错了N遍
     * <p>
     * 执行用时：11 ms, 在所有 Java 提交中击败了72.14%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了24.20%的用户
     * 通过测试用例：43 / 43
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        deque.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (k > 0 && !deque.isEmpty() && deque.peek() > num.charAt(i)) {
                deque.pop();
                k--;
            }
            deque.push(num.charAt(i));
        }
        while (k > 0) {
            deque.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        boolean pre = true;
        while (!deque.isEmpty()) {
            // 去掉前导零
            char c = deque.removeLast();
            if (pre && c == '0') {
                continue;
            }
            pre = false;
            builder.append(c);

        }
        return builder.length() > 0 ? builder.toString() : "0";
    }
}

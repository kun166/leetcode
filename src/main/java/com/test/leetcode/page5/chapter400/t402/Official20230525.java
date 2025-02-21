package com.test.leetcode.page5.chapter400.t402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Official20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 08:04
 * @Version: 1.0
 */
public class Official20230525 {

    /**
     * 方法一：贪心 + 单调栈
     * 对于两个相同长度的数字序列，最左边不同的数字决定了这两个数字的大小，
     * 例如，对于A=1axxx，B=1bxxx，如果 a>b 则 A>B。
     * 基于此，我们可以知道，若要使得剩下的数字最小，需要保证靠前的数字尽可能小。
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}

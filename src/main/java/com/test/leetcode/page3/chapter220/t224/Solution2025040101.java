package com.test.leetcode.page3.chapter220.t224;

import java.util.LinkedList;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 15:24
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 呃,试下用栈脱括号吧
     * 42.71MB	击败81.85%
     * <p>
     * 5ms	击败95.36%
     */
    public int calculate(String s) {
        int ans = 0, cur = 0, n = s.length(), curSign = 1;
        // 遇括号就加1或者-1
        LinkedList<Integer> ll = new LinkedList<>();
        // 默认先加个+号
        ll.push(1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (c == '+') {
                ans += curSign * cur;
                cur = 0;
                curSign = ll.peek();
            } else if (c == '-') {
                ans += curSign * cur;
                cur = 0;
                curSign = -ll.peek();
            } else if (c == '(') {
                ans += curSign * cur;
                cur = 0;
                ll.push(curSign);
            } else if (c == ')') {
                ans += curSign * cur;
                cur = 0;
                ll.pop();
            } else {
                cur = cur * 10 + (c - '0');
            }
        }
        ans += curSign * cur;
        return ans;
    }
}

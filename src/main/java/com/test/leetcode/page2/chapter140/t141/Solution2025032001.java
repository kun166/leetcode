package com.test.leetcode.page2.chapter140.t141;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 10:27
 * @Version: 1.0
 */
public class Solution2025032001 {

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        /**
         * 呃，好吧，这个first根本不需要判……
         */
        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second)
                return true;
        }
        return false;
    }
}

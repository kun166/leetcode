package com.test.leetcode.page2.chapter140.t142;

import com.test.leetcode.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-27 11:15
 */
public class Other20230202 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode c1 = head;
        ListNode c2 = head;
        while (true) {
            if (c2.next == null || c2.next.next == null) {
                return null;
            }
            c1 = c1.next;
            c2 = c2.next.next;
            if (c1 == c2) {
                break;
            }
        }
        c1 = head;
        while (c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;
    }
}

package com.test.leetcode.page2.chapter140.t142;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 10:05
 * @Version: 1.0
 */
public class Official20230202 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

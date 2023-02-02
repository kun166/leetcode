package com.test.leetcode.page2.chapter140.t141;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 08:38
 * @Version: 1.0
 */
public class Official20230202 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

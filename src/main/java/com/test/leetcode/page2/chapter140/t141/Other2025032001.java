package com.test.leetcode.page2.chapter140.t141;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Other2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 10:38
 * @Version: 1.0
 */
public class Other2025032001 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

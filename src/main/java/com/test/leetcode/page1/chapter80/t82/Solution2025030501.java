package com.test.leetcode.page1.chapter80.t82;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025030501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 11:24
 * @Version: 1.0
 */
public class Solution2025030501 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        ListNode root = dummy;
        ListNode pre = null;
        while (head != null) {
            if ((pre == null || head.val != pre.val) && (head.next == null || head.val != head.next.val)) {
                root.next = head;
                root = root.next;
            }
            pre = head;
            head = head.next;
        }
        root.next = null;
        return dummy.next;
    }
}

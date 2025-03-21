package com.test.leetcode.page2.chapter140.t147;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 08:35
 * @Version: 1.0
 */
public class Solution2025032101 {

    /**
     * 21ms	击败37.85%
     * 43.43MB	击败95.60%
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node, next, headNext;
        while (head != null) {
            node = dummy;
            while (node.next != null && node.next.val <= head.val) {
                node = node.next;
            }
            next = node.next;
            headNext = head.next;
            node.next = head;
            head.next = next;
            head = headNext;
        }
        return dummy.next;
    }
}

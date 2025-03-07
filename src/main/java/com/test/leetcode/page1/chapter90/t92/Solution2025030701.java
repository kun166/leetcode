package com.test.leetcode.page1.chapter90.t92;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025030701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 11:12
 * @Version: 1.0
 */
public class Solution2025030701 {

    /**
     * 这题和翻转整个链表有啥不同？
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        // 先找到需要翻转的第一个节点之前的那个节点
        ListNode pre = dummy;
        right = right - left + 1;
        while (--left > 0)
            pre = pre.next;
        // 记录下新的尾节点
        ListNode tail = pre.next;
        ListNode newHead = null;
        head = tail;
        ListNode next;
        while (--right >= 0) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        pre.next = newHead;
        tail.next = head;
        return dummy.next;
    }
}

package com.test.leetcode.page1.chapter60.t61;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025022701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 14:34
 * @Version: 1.0
 */
public class Solution2025022701 {

    public ListNode rotateRight(ListNode head, int k) {
        // 求整个链表的长度
        int length = 0;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }
        if (length <= 1) {
            return head;
        }
        k = k % length;

        /**
         * 好吧，这个地方遗漏了……
         */
        if (k == 0) {
            return head;
        }
        // 找到倒数第k+1那个节点,也即length - k那个节点
        int number = length - k;
        next = head;
        while (--number > 0) {
            next = next.next;
        }
        // 组织新的头节点
        ListNode newHead = next.next;
        next.next = null;
        // 找尾节点
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 尾节点的下一个节点是以前的头节点
        tail.next = head;
        return newHead;
    }
}

package com.test.leetcode.page2.chapter140.t143;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032002
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 14:48
 * @Version: 1.0
 */
public class Solution2025032002 {

    /**
     * 快慢指针……
     * 1ms	击败100.00%
     * 47.54MB	击败5.06%
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        /**
         * 呃,没加判断，加了判断没最后那个……
         */
        if (head == null || head.next == null || head.next.next == null)
            return;
        // 1,快慢指针找出第二个链表的头结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        // 2,第二个链表反转
        secondHead = revers(secondHead);
        //3,合并两个链表
        while (secondHead != null) {
            // 3.1 头两个节点建立关系
            ListNode firstNext = head.next;
            ListNode secondNext = secondHead.next;
            head.next = secondHead;
            secondHead.next = firstNext;
            // 3.2循环下一轮
            head = firstNext;
            secondHead = secondNext;
        }
    }

    public ListNode revers(ListNode head) {
        ListNode previous = null;
        /**
         * 为了返回最后一个节点,即最后一个节点不能为null,所以用
         * head.next != null
         * 来判断循环
         */
        while (head.next != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        /**
         * 最后一节点在循环中没有加入链表,需要加入
         */
        head.next = previous;
        return head;
    }
}

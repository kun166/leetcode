package com.test.leetcode.page2.chapter140.t143;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 14:12
 * @Version: 1.0
 */
public class Solution2025032001 {

    /**
     * 呃,先简单的来一遍吧
     * <p>
     * 1ms	击败100.00%
     * 46.98MB	击败91.02%
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        // 1,求出链表长度
        int length = 0;
        ListNode root = head;
        while (head != null) {
            length++;
            head = head.next;
        }
        if (length < 3) {
            return;
        }
        // 2,找出下半段的起始位置
        int half = length >> 1;
        head = root;
        while (--half >= 0) {
            head = head.next;
        }

        ListNode nextHalf = head.next;
        head.next = null;
        // 3,翻转nextHalf
        nextHalf = revers(nextHalf);

        // 4,合并链表
        head = root;
        while (nextHalf != null) {
            ListNode next = head.next;
            head.next = nextHalf;
            ListNode nh = nextHalf.next;
            nextHalf.next = next;
            head = next;
            nextHalf = nh;
        }


    }

    public ListNode revers(ListNode head) {
        ListNode pre = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}

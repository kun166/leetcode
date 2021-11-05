package com.test.leetcode.page1.chapter20.t24;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 10:33
 */
public class Solution20201026 {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        l1 = swapPairs(l1);

        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设置一个根
        ListNode root = new ListNode(0);
        ListNode pre = root;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            // 上一个节点指定
            pre.next = next;
            head.next = next.next;
            next.next = head;

            pre = head;
            head = head.next;
        }
        return root.next;
    }

    private class ListNode {

        private ListNode next;
        private int val;

        ListNode(int val) {
            this.val = val;
        }

    }
}

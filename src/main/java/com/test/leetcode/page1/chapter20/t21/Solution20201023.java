package com.test.leetcode.page1.chapter20.t21;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 16:50
 */
public class Solution20201023 {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode node = mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode parent = root;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                parent.next = l1;
                l1 = l1.next;
            } else {
                parent.next = l2;
                l2 = l2.next;
            }
            parent = parent.next;
        }
        while (l1 != null) {
            parent.next = l1;
            l1 = l1.next;
            parent = parent.next;
        }
        while (l2 != null) {
            parent.next = l2;
            l2 = l2.next;
            parent = parent.next;
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

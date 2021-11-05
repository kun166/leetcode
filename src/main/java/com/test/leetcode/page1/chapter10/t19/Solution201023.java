package com.test.leetcode.page1.chapter10.t19;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 11:01
 */
public class Solution201023 {

    @Test
    public void test() {
        ListNode<Integer> head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode<Integer> newNode = removeNthFromEnd(head, 2);
        while (newNode != null) {
            System.out.print(newNode.val);
            newNode = newNode.next;
        }

        head = new ListNode(1);
        newNode = removeNthFromEnd1(head, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode first = root, second = root;
        while (n > 0) {
            first = first.next;
            n--;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return root.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode first = head, second = head;
        while (n > 0) {
            first = first.next;
            n--;
        }
        if (first == null)
            return head.next;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return head;
    }

    private class ListNode<T> {

        private ListNode next;
        private T val;

        ListNode(T val) {
            this.val = val;
        }

    }
}

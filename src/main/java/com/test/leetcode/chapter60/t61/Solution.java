package com.test.leetcode.chapter60.t61;

import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * Created by qinfajia on 2020/11/8.
 */
public class Solution {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = rotateRight(node, 6);
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int length = 0;
        ListNode node = head;
        while (k > 0 && node != null) {
            length++;
            k--;
            node = node.next;
        }
        if (k == 0 && node == null) {
            return head;
        }
        ListNode pre = head;
        if (k == 0) {
            while (node.next != null) {
                node = node.next;
                pre = pre.next;
            }
            ListNode ans = pre.next;
            node.next = head;
            pre.next = null;
            return ans;
        }
        k = k % length;
        if (k == 0)
            return head;
        node = head;
        while (k > 0) {
            k--;
            node = node.next;
        }
        while (node.next != null) {
            node = node.next;
            pre = pre.next;
        }
        ListNode ans = pre.next;
        node.next = head;
        pre.next = null;
        return ans;
    }
}

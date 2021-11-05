package com.test.leetcode.page2.chapter140.t143;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-29 19:32
 */
public class Solution {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(JSON.toJSONString(head));
        reorderList(head);
        System.out.println(JSON.toJSONString(head));
    }

    public void reorderList(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        if (length < 3) {
            return;
        }
        int mid = length / 2;
        node = head;
        while (mid > 0) {
            node = node.next;
            mid--;
        }
        ListNode pre = node;
        ListNode current = node.next;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        node.next = null;
        node = head;
        mid = length / 2;
        while (mid > 0) {
            ListNode next = node.next;
            node.next = pre;
            ListNode p = pre.next;
            if (pre == next) {
                break;
            }
            pre.next = next;
            node = next;
            pre = p;
            mid--;
        }
    }
}

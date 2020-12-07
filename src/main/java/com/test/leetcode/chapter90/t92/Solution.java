package com.test.leetcode.chapter90.t92;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-04 15:08
 */
public class Solution {

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int i : array) {
            next.next = new ListNode(i);
            next = next.next;
        }
        System.out.println(JSON.toJSONString(root.next));
        ListNode head = reverseBetween(root.next, 1, 4);
        System.out.println(JSON.toJSONString(head));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        n -= m;
        while (m > 1) {
            pre = pre.next;
            m--;
        }
        ListNode first = pre.next;
        ListNode last = first;
        ListNode next = first.next;
        while (n > 0) {
            ListNode current = next;
            next = current.next;
            current.next = last;
            last = current;
            n--;
        }
        first.next = next;
        pre.next = last;
        return root.next;
    }
}

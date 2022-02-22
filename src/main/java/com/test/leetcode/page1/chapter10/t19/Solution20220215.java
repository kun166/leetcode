package com.test.leetcode.page1.chapter10.t19;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20220215
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/15 16:41
 * @Version: 1.0
 */
public class Solution20220215 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode first = root;
        ListNode second = root;
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
}

package com.test.leetcode.page1.chapter20.t24;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 14:40
 * @Version: 1.0
 */
public class Solution20221008 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode root = dummy;
        while (root.next != null && root.next.next != null) {
            ListNode first = root.next;
            ListNode second = first.next;
            ListNode next = second.next;

            root.next = second;
            second.next = first;
            first.next = next;
            root = first;
        }
        return dummy.next;
    }
}

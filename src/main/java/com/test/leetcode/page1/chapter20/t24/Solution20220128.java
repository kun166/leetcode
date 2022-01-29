package com.test.leetcode.page1.chapter20.t24;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20220128
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/28 11:16
 * @Version: 1.0
 */
public class Solution20220128 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        ListNode pre = root;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                pre.next = head;
                head = null;
            } else {
                // 上一个节点指向next
                pre.next = next;
                // pre指向了head,作为下一次循环
                pre = head;
                // head的next指向
                head.next = next.next;
                next.next = head;
                head = head.next;
            }
        }
        return root.next;
    }
}

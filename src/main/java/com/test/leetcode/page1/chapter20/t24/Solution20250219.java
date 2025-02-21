package com.test.leetcode.page1.chapter20.t24;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20250219
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 17:26
 * @Version: 1.0
 */
public class Solution20250219 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (head != null) {
            if (head.next != null) {
                // 有两个，互换
                ListNode next = head.next.next;
                pre.next = head.next;
                pre.next.next = head;
                pre = pre.next.next;
                head = next;
            } else {
                // 最后一个了
                pre.next = head;
                head = head.next;
                pre = pre.next;
            }
        }
        pre.next = null;
        return dummy.next;
    }
}

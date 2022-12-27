package com.test.leetcode.page1.chapter80.t86;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20221227
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/27 08:47
 * @Version: 1.0
 */
public class Solution20221227 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val < x) {
                // 换位置了
                ListNode next = cur.next;
                cur.next = cur.next.next;

                next.next = pre.next;
                pre.next = next;
                pre = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

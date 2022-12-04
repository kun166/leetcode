package com.test.leetcode.page1.chapter80.t83;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20221204
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/4 15:42
 * @Version: 1.0
 */
public class Official20221204 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}

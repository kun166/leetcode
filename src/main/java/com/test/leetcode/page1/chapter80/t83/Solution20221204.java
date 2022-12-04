package com.test.leetcode.page1.chapter80.t83;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20221204
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/4 11:23
 * @Version: 1.0
 */
public class Solution20221204 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        while (cur != null && cur.next != null) {

            if (cur.val == cur.next.val) {
                // 如果相等就略过
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

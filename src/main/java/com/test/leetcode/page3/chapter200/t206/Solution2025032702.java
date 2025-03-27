package com.test.leetcode.page3.chapter200.t206;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 14:35
 * @Version: 1.0
 */
public class Solution2025032702 {

    /**
     * 递归
     * 如果递归返回尾节点,也即新头节点,则没法递归……
     * <p>
     * 0ms	击败100.00%
     * 41.56MB	击败68.93%
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode pre) {
        if (head.next == null) {
            head.next = pre;
            return head;
        }
        /**
         * 呃，这个地方写错了
         * head.next = pre;
         * return reverseList(head.next, head);
         */
        ListNode next = head.next;
        head.next = pre;
        return reverseList(next, head);
    }
}

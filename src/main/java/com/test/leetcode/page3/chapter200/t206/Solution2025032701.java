package com.test.leetcode.page3.chapter200.t206;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 14:35
 * @Version: 1.0
 */
public class Solution2025032701 {

    /**
     * 先来个迭代方式吧
     * <p>
     * 0ms	击败100.00%
     * 41.57MB	击败67.36%
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null, next;
        while (head.next != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}

package com.test.leetcode.page3.chapter200.t206;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficialSecond20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/21 09:06
 * @Version: 1.0
 */
public class OfficialSecond20230220 {

    /**
     * 这写法也牛逼啊……
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

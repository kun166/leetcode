package com.test.leetcode.page4.chapter320.t328;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20230425
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/25 09:18
 * @Version: 1.0
 */
public class Official20230425 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

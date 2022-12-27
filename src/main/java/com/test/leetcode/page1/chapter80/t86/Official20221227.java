package com.test.leetcode.page1.chapter80.t86;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20221227
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/27 09:00
 * @Version: 1.0
 */
public class Official20221227 {

    /**
     * 这个解法我只能说，真的是太骚了
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}

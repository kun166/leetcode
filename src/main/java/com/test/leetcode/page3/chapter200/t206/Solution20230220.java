package com.test.leetcode.page3.chapter200.t206;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 10:11
 * @Version: 1.0
 */
public class Solution20230220 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        // 呃，这个地方用head!=null判断，然后return pre,则head.next = pre;这一行代码也省了……这行代码很容易出错啊
        while (head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}

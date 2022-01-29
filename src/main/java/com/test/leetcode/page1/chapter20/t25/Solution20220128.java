package com.test.leetcode.page1.chapter20.t25;

import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20220128
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/28 14:12
 * @Version: 1.0
 */
public class Solution20220128 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseKGroup(head, 2);
    }

    /**
     * 1,2,3,4,5
     * k=2
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode();
        ListNode pre = root;
        while (head != null) {
            pre.next = head;
            int step = k - 1;
            ListNode h = head;
            while (step > 0 && head != null) {
                step--;
                head = head.next;
            }
            if (step == 0 && head != null) {
                ListNode next = head.next;
                pre.next = reverse(h, head);
                head = next;
                pre = h;
            }
        }
        return root.next;
    }

    /**
     * 翻转
     *
     * @param head
     * @param tail
     * @return
     */
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode h = null;
        while (head != tail) {
            ListNode next = head.next;
            head.next = h;
            h = head;
            head = next;
        }
        tail.next = h;
        return tail;
    }
}

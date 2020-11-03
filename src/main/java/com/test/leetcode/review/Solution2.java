package com.test.leetcode.review;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-30 14:26
 */
public class Solution2 {

    @Test
    public void test() {
        ListNode f = new ListNode(2);
        f.next = new ListNode(4);
        f.next.next = new ListNode(3);

        ListNode s = new ListNode(5);
        s.next = new ListNode(6);
        s.next.next = new ListNode(4);
        s.next.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(f, s);
        while (result != null) {
            System.out.print(result.val);
            System.out.print("->");
            result = result.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode next = result;
        int sum, v1, v2, m = 0;
        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2 + m;
            m = sum > 9 ? 1 : 0;
            next.next = new ListNode(sum > 9 ? sum - 10 : sum);
            next = next.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (m > 0) next.next = new ListNode(m);
        return result.next;
    }


    class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

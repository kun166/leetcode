package com.test.leetcode.page1.chapter10.t19;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 19:35
 */
public class OfficialSolution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    private static class ListNode {
        private int value;
        private ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

}

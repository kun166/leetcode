package com.test.leetcode.page2.chapter160.t160;

import com.test.leetcode.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-05 17:24
 */
public class SolutionOffice {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

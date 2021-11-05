package com.test.leetcode.page2.chapter160.t160;

import com.test.leetcode.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-05 11:24
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);

        ListNode reversA = revers(headA);
        ListNode lastB = headB;
        int lB = 1;
        while (lastB.next != null) {
            lastB = lastB.next;
            lB++;
        }
        if (lastB == headA) {
            int length = lengthB - (lengthA + lengthB - lB + 1) / 2;
            ListNode node = headB;
            while (length > 0) {
                node = node.next;
                length--;
            }
            revers(reversA);
            return node;
        }
        revers(reversA);
        //说明不想交
        return null;
    }

    public ListNode revers(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public int length(ListNode node) {
        if (node == null) {
            return 0;
        }
        int length = 1;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}

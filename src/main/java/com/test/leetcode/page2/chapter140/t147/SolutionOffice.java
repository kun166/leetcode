package com.test.leetcode.page2.chapter140.t147;

import com.test.leetcode.ListNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-03 10:32
 */
public class SolutionOffice {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 设置个虚节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // lastSorted 排好序的最后那个节点。curr当前遍历的节点
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                // 如果前一个节点小于等于后一个节点，说明是已经排好序了
                lastSorted = lastSorted.next;
            } else {
                // 将当前节点插入到原来已经排好序的链表中
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}

package com.test.leetcode.page2.chapter140.t147;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Other2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 08:54
 * @Version: 1.0
 */
public class Other2025032101 {

    /**
     * 2ms	击败98.90%
     * 43.64MB	击败51.06%
     * <p>
     * 呃，这题精妙在已经排好序的就直接略过了……
     * 速度居然相差这么多……
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode lastSorted = head;

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}

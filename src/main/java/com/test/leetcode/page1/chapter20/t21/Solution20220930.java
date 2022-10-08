package com.test.leetcode.page1.chapter20.t21;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20220930
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/30 14:44
 * @Version: 1.0
 */
public class Solution20220930 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return dummy.next;
    }
}

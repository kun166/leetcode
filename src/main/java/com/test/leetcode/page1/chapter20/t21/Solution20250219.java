package com.test.leetcode.page1.chapter20.t21;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20250219
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 14:49
 * @Version: 1.0
 */
public class Solution20250219 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode next = ans;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                next.next = list2;
                list2 = list2.next;
            } else {
                next.next = list1;
                list1 = list1.next;
            }
            next = next.next;
        }
        next.next = list1 == null ? list2 : list1;
        return ans.next;
    }
}

package com.test.leetcode.page1.chapter20.t21;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20220126
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/26 18:50
 * @Version: 1.0
 */
public class Solution20220126 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode ln = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ln.next = list1;
                list1 = list1.next;
            } else {
                ln.next = list2;
                list2 = list2.next;
            }
            ln = ln.next;
        }
        if (list1 == null) {
            ln.next = list2;
        }
        if (list2 == null) {
            ln.next = list1;
        }
        return root.next;
    }
}

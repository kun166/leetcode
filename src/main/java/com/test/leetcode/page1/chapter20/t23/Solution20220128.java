package com.test.leetcode.page1.chapter20.t23;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20220128
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/28 10:35
 * @Version: 1.0
 */
public class Solution20220128 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        ListNode merge = lists[0];
        for (int i = 1; i < length; i++) {
            merge = mergeKLists(merge, lists[i]);
        }
        return merge;
    }

    public ListNode mergeKLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode head = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return root.next;
    }
}

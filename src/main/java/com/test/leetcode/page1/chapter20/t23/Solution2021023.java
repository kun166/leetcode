package com.test.leetcode.page1.chapter20.t23;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 18:16
 */
public class Solution2021023 {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode root = new ListNode(0);
        ListNode parent = root;
        int length = lists.length;

        int noNullCount;
        do {
            noNullCount = 0;
            int minValue = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < length; i++) {
                if (lists[i] != null) {
                    noNullCount++;
                    if (lists[i].val < minValue) {
                        minValue = lists[i].val;
                        index = i;
                    }
                }
            }
            if (noNullCount != 0) {
                // 说明肯定有值
                parent.next = lists[index];
                parent = parent.next;
                lists[index] = lists[index].next;
                if (lists[index] == null) {
                    noNullCount--;
                }
            }
        } while (noNullCount != 0);
        return root.next;
    }

    private class ListNode {

        private ListNode next;
        private int val;

        ListNode(int val) {
            this.val = val;
        }

    }
}

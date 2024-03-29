package com.test.leetcode.page1.chapter20.t21;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 09:45
 */
public class OfficialSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    /**
     * 看这牛逼PLUS的解题思路，递归居然能返回参数
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode recursionMergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = recursionMergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = recursionMergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }
}

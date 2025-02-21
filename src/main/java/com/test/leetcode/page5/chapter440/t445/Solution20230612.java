package com.test.leetcode.page5.chapter440.t445;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230612
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/12 10:26
 * @Version: 1.0
 */
public class Solution20230612 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了26.66%的用户
     * 通过测试用例：1563 / 1563
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先翻转
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        boolean more = false;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (more ? 1 : 0);
            more = sum > 9 ? true : false;
            head.next = new ListNode(sum > 9 ? sum - 10 : sum);
            head = head.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (more) {
            head.next = new ListNode(1);
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        node.next = pre;
        return node;
    }
}

package com.test.leetcode.page1.chapter0.t2;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20220621
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/21 09:25
 * @Version: 1.0
 */
public class Solution20220621 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode preNode = root;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            if (sum > 9) {
                add = 1;
                sum = sum - 10;
            } else {
                add = 0;
            }
            preNode.next = l1;
            l1.val = sum;
            preNode = preNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            addTwoNumbers(l1, add, preNode);
        } else {
            addTwoNumbers(l2, add, preNode);
        }
        return root.next;
    }

    private void addTwoNumbers(ListNode node, int add, ListNode preNode) {
        while (node != null) {
            int sum = node.val + add;
            if (sum > 9) {
                add = 1;
                sum -= 10;
            } else {
                add = 0;
            }
            preNode.next = node;
            node.val = sum;
            node = node.next;
            preNode = preNode.next;
        }
        if (add > 0) {
            preNode.next = new ListNode(add);
        }
    }
}

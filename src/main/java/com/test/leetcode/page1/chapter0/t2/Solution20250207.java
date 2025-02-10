package com.test.leetcode.page1.chapter0.t2;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20250207
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/7 14:48
 * @Version: 1.0
 */
public class Solution20250207 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int m = 0;
        ListNode ans = new ListNode();
        ListNode root = ans;
        while (l1 != null && l2 != null) {
            int sum = m + l1.val + l2.val;
            ans.next = new ListNode(sum > 9 ? sum - 10 : sum);
            m = sum > 9 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
            ans = ans.next;
        }
        l1 = l1 == null ? l2 : l1;
        while (l1 != null) {
            int sum = m + l1.val;
            ans.next = new ListNode(sum > 9 ? sum - 10 : sum);
            m = sum > 9 ? 1 : 0;
            l1 = l1.next;
            ans = ans.next;
        }
        if (m > 0) {
            ans.next = new ListNode(m);
        }
        return root.next;
    }
}

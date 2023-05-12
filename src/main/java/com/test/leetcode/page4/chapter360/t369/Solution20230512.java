package com.test.leetcode.page4.chapter360.t369;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230512
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/12 09:14
 * @Version: 1.0
 */
public class Solution20230512 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了5.14%的用户
     * 通过测试用例：108 / 108
     *
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        boolean add = true;
        head = revers(head);
        ListNode node = head;
        while (node != null) {
            int value = node.val + 1;
            if (value < 10) {
                node.val = value;
                add = false;
                break;
            } else {
                node.val = value - 10;
                if (node.next == null) {
                    break;
                }
                node = node.next;
            }
        }
        if (add) {
            node.next = new ListNode(1);
        }
        return revers(head);
    }

    public ListNode revers(ListNode head) {
        ListNode pre = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}

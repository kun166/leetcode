package com.test.leetcode.page4.chapter320.t328;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230425
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/25 09:00
 * @Version: 1.0
 */
public class Solution20230425 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了70.63%的用户
     * 通过测试用例：70 / 70
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 奇数，偶数
        ListNode dummy = new ListNode();
        ListNode first = dummy;
        first.next = head;
        ListNode second = null;
        ListNode secondHead = null;
        int count = 0;
        while (head.next != null) {
            if (count % 2 == 0) {
                if (second == null) {
                    second = head.next;
                    secondHead = second;
                } else {
                    second.next = head.next;
                    second = second.next;
                }
            } else {
                first = first.next;
                first.next = head.next;
            }
            count++;
            head = head.next;
        }
        if (second != null) {
            second.next = null;
            first = first.next;
            first.next = secondHead;
        }
        return dummy.next;
    }
}

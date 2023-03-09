package com.test.leetcode.page3.chapter230.t244;

import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: SolutionThird20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 10:08
 * @Version: 1.0
 */
public class SolutionThird20230309 {

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            }
        }
        if (first.next == null) {
            return true;
        }
        // 对second进行翻转;
        second = revers(first.next);
        first = head;
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public ListNode revers(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}

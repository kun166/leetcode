package com.test.leetcode;

/**
 * @ClassName: ListNodeUtil
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 16:19
 * @Version: 1.0
 */
public class ListNodeUtil {

    public static ListNode createListNode(int... array) {
        ListNode ans = new ListNode();
        ListNode next = ans;
        for (int i : array) {
            next.next = new ListNode(i);
            next = next.next;
        }
        return ans.next;
    }
}

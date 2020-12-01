package com.test.leetcode.chapter80.t83;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-14 15:06
 */
public class Solution {

    @Test
    public void test() {
        int[] array = new int[]{1, 1, 2, 3, 3};
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int i : array) {
            next.next = new ListNode(i);
            next = next.next;
        }
        System.out.println(JSON.toJSONString(root.next));
        ListNode head = deleteDuplicates(root.next);
        System.out.println(JSON.toJSONString(head));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode root = head;
        ListNode pre = head;
        while (head != null) {
            if (pre.val != head.val) {
                pre.next = head;
                pre = pre.next;
            }
            head = head.next;
        }
        pre.next = null;
        return root;
    }
}

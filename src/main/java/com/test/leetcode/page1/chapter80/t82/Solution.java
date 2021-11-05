package com.test.leetcode.page1.chapter80.t82;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-14 10:49
 */
public class Solution {

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 2};
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
        ListNode root = new ListNode(0);
        ListNode r = root;
        ListNode dup = null;
        while (head != null) {
            ListNode next = head.next;
            if (next == null || head.val != next.val) {
                if (dup == null) {
                    r.next = head;
                    r = r.next;
                } else
                    dup = null;
            } else {
                dup = head;
            }
            head = next;
        }
        r.next = null;
        return root.next;
    }
}

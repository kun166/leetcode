package com.test.leetcode.chapter80.t86;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-26 20:19
 */
public class Solution {

    @Test
    public void test() {
        int[] array = new int[]{1, 4, 3, 2, 5, 2};
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int i : array) {
            next.next = new ListNode(i);
            next = next.next;
        }
        System.out.println(JSON.toJSONString(root.next));
        ListNode head = partition(root.next, 3);
        System.out.println(JSON.toJSONString(head));
    }


    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode root = new ListNode(0);
        ListNode pre = null;
        boolean find = false;
        if (head.val >= x) {
            pre = root;
        } else {
            root.next = head;
        }
        if (head.val == x)
            find = true;
        while (head != null) {
            if (head.next != null && head.next.val >= x && pre == null) {
                pre = head;
            }
            if (find && head.val < x) {
                ListNode preNext = pre.next;
                pre.next = head;
                head = head.next;
                pre.next.next = preNext;
                pre = pre.next;
            } else {
                if (head.val == x)
                    find = true;
                head = head.next;
            }
        }
        return root.next;
    }
}

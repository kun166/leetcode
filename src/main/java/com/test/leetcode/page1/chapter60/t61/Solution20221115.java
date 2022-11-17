package com.test.leetcode.page1.chapter60.t61;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20221115
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/15 11:43
 * @Version: 1.0
 */
public class Solution20221115 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode first = head;
        while (first != null && k > 0) {
            first = first.next;
            length++;
            k--;
        }
        if (first != null) {
            ListNode second = head;
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            ListNode next = second.next;
            second.next = null;
            first.next = head;
            return next;
        } else {
            if (k == 0) {
                return head;
            }
            k = k % length;
            if (k == 0) {
                return head;
            }
            first = head;
            while (k > 0) {
                first = first.next;
                k--;
            }
            ListNode second = head;
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            ListNode next = second.next;
            second.next = null;
            first.next = head;
            return next;
        }
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);

        System.out.println(JSON.toJSONString(rotateRight(node, 99)));
    }
}

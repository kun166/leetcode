package com.test.leetcode.page1.chapter20.t25;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 15:33
 * @Version: 1.0
 */
public class Solution20221008 {

    @Test
    public void test() {
        ListNode pre = new ListNode(1);
        pre.next = new ListNode(2);
        pre.next.next = new ListNode(3);
        pre.next.next.next = new ListNode(4);
        System.out.println(JSON.toJSONString(pre));
        System.out.println(JSON.toJSONString(reverse(pre, pre.next.next)));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode root = dummy;
        while (true) {
            // 先找到tail
            int count = k;
            ListNode tail = head;
            while (--count > 0) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            // 翻转
            root.next = reverse(head, tail);
            root = head;
            head = root.next;
            if (head == null) {
                return dummy.next;
            }
        }
    }


    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        tail.next = pre;
        return tail;
    }
}

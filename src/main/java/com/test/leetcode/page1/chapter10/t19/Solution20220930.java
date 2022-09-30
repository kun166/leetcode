package com.test.leetcode.page1.chapter10.t19;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20220930
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/30 09:56
 * @Version: 1.0
 */
public class Solution20220930 {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(JSON.toJSONString(head));

        System.out.println(JSON.toJSONString(removeNthFromEnd(head, 1)));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode first = root;
        ListNode second = root;
        while (n-- >= 0) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return root.next;
    }
}

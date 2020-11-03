package com.test.leetcode.chapter20.t25;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 15:31
 */
public class TurnListNode {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
//        node = turn(node);
//        while (node != null) {
//            System.out.print(node.value);
//            System.out.print("->");
//            node = node.next;
//        }

        int k = 3;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        System.out.print(node.value);

    }

    public ListNode turn(ListNode node) {
        ListNode next;
        ListNode pre = null;
        while (node != null) {
            // 先记录下来下一个节点
            next = node.next;
            // 当前节点的下一个节点指向前一个节点
            node.next = pre;
            // 前一个节点只想当前节点
            pre = node;
            // 当前节点指向next，进入下一次循环
            node = next;
        }

        return pre;
    }


    private static class ListNode {
        private int value;
        private ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}

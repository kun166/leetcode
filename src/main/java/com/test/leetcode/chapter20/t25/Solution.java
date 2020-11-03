package com.test.leetcode.chapter20.t25;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 14:31
 */
public class Solution {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        //node.next.next.next.next.next = new ListNode(6);
        node = reverseKGroup(node, 5);
        while (node != null) {
            System.out.print(node.value);
            System.out.print("->");
            node = node.next;
        }
    }


    public ListNode trans(ListNode node, int k) {
        // 申请k个空间
        ListNode[] array = new ListNode[k];
        // 定义一个最上层的node
        ListNode root = new ListNode(0);
        // 最上层的node赋值为node
        root.next = node;
        //每一次循环的上一个节点
        ListNode preNode = root;
        // 每次循环的下一个节点。
        ListNode endNext;
        int index;
        while (node != null) {
            index = k;
            array[0] = null;
            while (index > 0 && node != null) {
                // 初始化array
                array[--index] = node;
                node = node.next;
            }
            // 如果第一个节点为空，则说明本次节点不够k个，直接返回
            if (array[0] == null) {
                break;
            }
            // array[0]是最后一个节点。赋值给endNext下一轮的开始节点
            endNext = array[0].next;
            for (int i = 0; i < k - 1; i++) {
                // 重新翻转节点
                array[i].next = array[i + 1];
            }
            array[k - 1].next = endNext;
            preNode.next = array[0];
            preNode = array[k - 1];
            node = endNext;
        }
        return root.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null)
                return head;
            tail = tail.next;
        }
        ListNode newNode = revser(head, tail);
        head.next = reverseKGroup(tail, k);
        return newNode;
    }

    public ListNode revser(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
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

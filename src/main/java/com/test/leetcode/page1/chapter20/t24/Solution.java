package com.test.leetcode.page1.chapter20.t24;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 11:23
 */
public class Solution {

    @Test
    public void test() {
        LinkedNode node = new LinkedNode(1);
        node.next = new LinkedNode(2);
        node.next.next = new LinkedNode(3);
        node.next.next.next = new LinkedNode(4);
        node.next.next.next.next = new LinkedNode(5);
        node.next.next.next.next.next = new LinkedNode(6);
        node = trans(node);
        while (node != null) {
            System.out.print(node.value);
            System.out.print("->");
            node = node.next;
        }
    }


    public LinkedNode trans(LinkedNode node) {
        LinkedNode result = null;
        LinkedNode pre = null;
        if (node == null || node.next == null) {
            return node;
        } else {
            result = node.next;
        }

        while (node != null) {
            LinkedNode next = node.next;
            if (next == null) {
                break;
            }
            LinkedNode third = next.next;
            if (pre != null) {
                pre.next = next;
            }

            next.next = node;
            node.next = third;
            pre = node;
            node = third;

        }
        return result;
    }


    private static class LinkedNode {
        private int value;
        private LinkedNode next;

        LinkedNode(int value) {
            this.value = value;
        }
    }
}

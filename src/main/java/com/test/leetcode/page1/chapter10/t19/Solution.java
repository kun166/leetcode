package com.test.leetcode.page1.chapter10.t19;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 17:41
 */
public class Solution {

    @Test
    public void test() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node n = officialRemove(node, 2);
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }


    public Node remove(Node node, int ri) {
        List<Node> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int index = list.size();
        index = index - ri;
        if (index == 0) {
            return list.get(1);
        } else {
            Node pre = list.get(index - 1);
            Node next = index + 1 < list.size() ? list.get(index + 1) : null;
            pre.next = next;
            return list.get(0);
        }
    }


    /**
     * 官网方法，神一样
     *
     * @param node
     * @param ri
     * @return
     */
    public Node officialRemove(Node node, int ri) {
        Node copy = node;
        Node second = null;
        int index = 0;
        while (copy != null) {
            copy = copy.next;
            if (second != null) second = second.next;
            if (index == ri) second = node;
            index++;
        }
        if (second == node) {
            return node.next;
        }
        second.next = second.next.next;
        return node;
    }


    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }
}

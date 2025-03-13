package com.test.leetcode.page2.chapter110.t117;

/**
 * @ClassName: Node
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 10:53
 * @Version: 1.0
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

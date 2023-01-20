package com.test.leetcode.page2.chapter110.t117;

/**
 * @ClassName: Solution20230120
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/20 16:07
 * @Version: 1.0
 */
public class Solution20230120 {

    public Node connect(Node root) {
        // 记录返回值
        Node head = root;
        while (root != null) {
            //向右。left用来记录向右
            Node left = root;
            Node pre = null;
            while (left != null) {
                if (left.left != null) {
                    if (pre != null) {
                        pre.next = left.left;
                    }
                    pre = left.left;
                }
                if (left.right != null) {
                    if (pre != null) {
                        pre.next = left.right;
                    }
                    pre = left.right;
                }
                left = left.next;
            }
            // 向下,root用来记录向下
            while (root != null) {
                Node down = root.left != null ? root.left : root.right;
                if (down != null) {
                    root = down;
                    break;
                }
                root = root.next;
            }
        }
        return head;
    }
}

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
}

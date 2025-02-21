package com.test.leetcode.page5.chapter420.t426;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20230605
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/5 16:03
 * @Version: 1.0
 */
public class Solution20230605 {

    @Test
    public void test() {
        Node root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        root = treeToDoublyList(root);
        System.out.println(JSON.toJSONString(root));
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了7.38%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了72.48%的用户
     * 通过测试用例：50 / 50
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        // root应该在left的队尾,且在right的队头
        if (left == null && right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        if (left == null) {
            Node last = getLast(right);
            root.right = right;
            root.left = last;
            right.left = root;
            last.right = root;
            return root;
        }
        if (right == null) {
            Node last = getLast(left);
            last.right = root;
            root.left = last;

            left.left = root;
            root.right = left;
            return left;
        }
        Node leftLast = getLast(left);
        Node rightLast = getLast(right);

        leftLast.right = root;
        root.left = leftLast;
        root.right = right;
        right.left = root;
        rightLast.right = left;
        left.left = rightLast;
        return left;
    }

    public Node getLast(Node root) {
        Node first = root;
        while (root.right != first) {
            root = root.right;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

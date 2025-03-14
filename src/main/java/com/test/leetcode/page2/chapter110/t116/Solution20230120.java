package com.test.leetcode.page2.chapter110.t116;

/**
 * @ClassName: Solution20230120
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/20 14:12
 * @Version: 1.0
 */
public class Solution20230120 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}



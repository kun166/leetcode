package com.test.leetcode.page2.chapter110.t116;

/**
 * @ClassName: Solution2025031201
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 10:52
 * @Version: 1.0
 */
public class Solution2025031201 {

    public Node connect(Node root) {
        if (root == null)
            return null;
        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}

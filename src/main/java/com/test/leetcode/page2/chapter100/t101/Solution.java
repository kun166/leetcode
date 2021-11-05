package com.test.leetcode.page2.chapter100.t101;

import com.test.leetcode.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-01-13 17:03
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

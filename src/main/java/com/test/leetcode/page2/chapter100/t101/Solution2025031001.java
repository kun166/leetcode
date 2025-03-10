package com.test.leetcode.page2.chapter100.t101;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 16:38
 * @Version: 1.0
 */
public class Solution2025031001 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left != null && right != null) {
            return left.val == right.val
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }
        return false;
    }
}

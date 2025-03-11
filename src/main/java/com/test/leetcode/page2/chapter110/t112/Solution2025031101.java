package com.test.leetcode.page2.chapter110.t112;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 16:14
 * @Version: 1.0
 */
public class Solution2025031101 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == targetSum;

        if (root.left != null && hasPathSum(root.left, targetSum - root.val))
            return true;

        if (root.right != null && hasPathSum(root.right, targetSum - root.val))
            return true;

        return false;
    }
}

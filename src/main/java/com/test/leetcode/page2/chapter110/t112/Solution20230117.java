package com.test.leetcode.page2.chapter110.t112;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 16:03
 * @Version: 1.0
 */
public class Solution20230117 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}

package com.test.leetcode.page2.chapter110.t110;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 15:04
 * @Version: 1.0
 */
public class Solution20230117 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean balance = isBalanced(root.left) && isBalanced(root.right);
        if (!balance) {
            return false;
        }
        int left = deep(root.left), right = deep(root.right);
        return left - right >= -1 && left - right <= 1;
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }
}

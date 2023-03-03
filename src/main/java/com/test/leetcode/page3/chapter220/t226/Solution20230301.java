package com.test.leetcode.page3.chapter220.t226;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230301
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/1 10:42
 * @Version: 1.0
 */
public class Solution20230301 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}

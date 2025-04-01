package com.test.leetcode.page3.chapter220.t226;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 16:22
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 0ms	击败100.00%
     * 40.25MB	击败80.15%
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }
}

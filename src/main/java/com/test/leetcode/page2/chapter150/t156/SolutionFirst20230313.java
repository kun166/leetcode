package com.test.leetcode.page2.chapter150.t156;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 09:30
 * @Version: 1.0
 */
public class SolutionFirst20230313 {

    private TreeNode ans;

    /**
     * 递归
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        upsideDownBinaryTree(root, null, null);
        return ans;
    }

    public void upsideDownBinaryTree(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            ans = null;
            return;
        }
        TreeNode next = root.left;
        TreeNode nextRight = root.right;
        root.right = left;
        root.left = right;
        if (next == null) {
            ans = root;
            return;
        }
        upsideDownBinaryTree(next, root, nextRight);
    }
}

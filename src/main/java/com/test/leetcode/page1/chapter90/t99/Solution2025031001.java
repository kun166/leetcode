package com.test.leetcode.page1.chapter90.t99;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 15:35
 * @Version: 1.0
 */
public class Solution2025031001 {

    /**
     * 这题正好受到98题的启发……
     * <p>
     * 呃，这解法是错误的示范……
     * 输入：[2,3,1]
     * 输出：[1,2,3]
     * 预期：[2,1,3]
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        recoverTree(root, null, null);
    }

    public void recoverTree(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return;
        if (left != null && root.val <= left.val) {
            int number = root.val;
            root.val = left.val;
            left.val = number;
            return;
        }
        if (right != null && root.val >= right.val) {
            int number = root.val;
            root.val = right.val;
            right.val = number;
            return;
        }
        recoverTree(root.left, left, root);
        recoverTree(root.right, root, right);
    }
}

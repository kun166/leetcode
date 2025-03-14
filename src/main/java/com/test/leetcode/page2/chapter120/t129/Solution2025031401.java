package com.test.leetcode.page2.chapter120.t129;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/14 10:57
 * @Version: 1.0
 */
public class Solution2025031401 {

    /**
     * 0ms	击败100.00%
     * 40.41MB	击败49.45%
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int parent) {
        int current = parent * 10 + root.val;
        if (root.left == null && root.right == null)
            return current;
        if (root.left != null && root.right != null)
            return sumNumbers(root.left, current) + sumNumbers(root.right, current);
        if (root.left != null)
            return sumNumbers(root.left, current);
        return sumNumbers(root.right, current);
    }
}

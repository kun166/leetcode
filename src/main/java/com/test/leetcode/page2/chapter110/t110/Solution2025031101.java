package com.test.leetcode.page2.chapter110.t110;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 15:13
 * @Version: 1.0
 */
public class Solution2025031101 {

    private boolean balance = true;

    /**
     * 1ms 击败40.04%
     * 43.52MB 击败57.32%
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        deep(root);
        return balance;
    }

    public int deep(TreeNode root) {
        if (root == null)
            return 0;
        int left = deep(root.left);
        int right = deep(root.right);
        if (Math.abs(left - right) > 1)
            balance = false;
        return Math.max(left, right) + 1;
    }
}

package com.test.leetcode.page2.chapter120.t124;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 15:38
 * @Version: 1.0
 */
public class Solution2025031301 {

    private int max = Integer.MIN_VALUE;

    /**
     * 递归
     * 1ms	击败47.98%
     * 43.45MB	击败68.18%
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        deep(root);
        return max;
    }

    public int deep(TreeNode root) {
        if (root == null)
            return 0;
        int left = deep(root.left);
        int right = deep(root.right);
        max = Math.max(max, root.val + left + right);
        int ans = root.val + Math.max(left, right);
        return ans > 0 ? ans : 0;
    }
}

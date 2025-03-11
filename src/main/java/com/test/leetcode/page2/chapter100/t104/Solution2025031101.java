package com.test.leetcode.page2.chapter100.t104;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 08:53
 * @Version: 1.0
 */
public class Solution2025031101 {

    /**
     * 递归?
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}

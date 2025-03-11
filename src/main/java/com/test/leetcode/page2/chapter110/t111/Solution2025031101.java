package com.test.leetcode.page2.chapter110.t111;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 15:28
 * @Version: 1.0
 */
public class Solution2025031101 {

    /**
     * 10ms 击败32.53%
     * 62.44MB 击败5.06%
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null)
            return 1;
        else if (root.right != null && root.left != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else
            return (root.left == null ? minDepth(root.right) : minDepth(root.left)) + 1;
    }
}

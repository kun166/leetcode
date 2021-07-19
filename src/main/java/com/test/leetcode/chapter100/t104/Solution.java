package com.test.leetcode.chapter100.t104;

import com.test.leetcode.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-05-19 11:12
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        return Math.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
    }
}

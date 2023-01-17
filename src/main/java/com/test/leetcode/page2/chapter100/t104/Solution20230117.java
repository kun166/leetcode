package com.test.leetcode.page2.chapter100.t104;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 10:30
 * @Version: 1.0
 */
public class Solution20230117 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

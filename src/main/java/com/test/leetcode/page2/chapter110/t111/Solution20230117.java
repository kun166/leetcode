package com.test.leetcode.page2.chapter110.t111;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 15:52
 * @Version: 1.0
 */
public class Solution20230117 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }
}

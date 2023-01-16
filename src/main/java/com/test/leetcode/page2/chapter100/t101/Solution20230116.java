package com.test.leetcode.page2.chapter100.t101;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 16:52
 * @Version: 1.0
 */
public class Solution20230116 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }


    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

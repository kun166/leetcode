package com.test.leetcode.page6.chapter530.t538;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230830
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/30 08:48
 * @Version: 1.0
 */
public class Solution20230830 {

    /**
     * 0ms,击败 100.00%使用 Java 的用户
     * 41.88MB,击败 53.27%使用 Java 的用户
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, null);
        return root;
    }

    public TreeNode convertBST(TreeNode current, TreeNode parent) {
        if (current == null) {
            return parent;
        }
        TreeNode right = convertBST(current.right, parent);
        current.val += right == null ? 0 : right.val;
        return convertBST(current.left, current);
    }

}

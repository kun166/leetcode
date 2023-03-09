package com.test.leetcode.page3.chapter230.t235;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: SolutionSecond20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 15:18
 * @Version: 1.0
 */
public class SolutionSecond20230309 {

    /**
     * 利用二叉树性质查找
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min = p.val > q.val ? q : p;
        TreeNode big = p.val > q.val ? p : q;
        while (root != null) {
            if (root.val == min.val || root.val == big.val) {
                return root;
            } else if (root.val > big.val) {
                root = root.left;
            } else if (root.val < min.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

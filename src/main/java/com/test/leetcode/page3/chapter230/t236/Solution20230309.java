package com.test.leetcode.page3.chapter230.t236;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 15:39
 * @Version: 1.0
 */
public class Solution20230309 {

    private TreeNode ans;

    /**
     * 方法一：递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }


}

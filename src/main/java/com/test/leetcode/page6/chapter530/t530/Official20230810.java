package com.test.leetcode.page6.chapter530.t530;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Official20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 11:23
 * @Version: 1.0
 */
public class Official20230810 {

    int pre;
    int ans;

    /**
     * 二叉树中序遍历，是一个递增数列
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}

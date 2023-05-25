package com.test.leetcode.page5.chapter400.t404;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OfficialFirst20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 10:07
 * @Version: 1.0
 */
public class OfficialFirst20230525 {

    /**
     * 方法一：深度优先搜索
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

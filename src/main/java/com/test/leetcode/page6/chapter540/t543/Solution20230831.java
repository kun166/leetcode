package com.test.leetcode.page6.chapter540.t543;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230831
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/31 11:23
 * @Version: 1.0
 */
public class Solution20230831 {

    int ans = 0;

    /**
     * 0ms
     * 击败 100.00%使用 Java 的用户
     * 39.76MB
     * 击败 11.55%使用 Java 的用户
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}

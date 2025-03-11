package com.test.leetcode.page2.chapter100.t104;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031102
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 08:57
 * @Version: 1.0
 */
public class Solution2025031102 {

    private int ans = 0;

    /**
     * 呃
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return ans;
    }

    public void maxDepth(TreeNode root, int deep) {
        if (root == null) {
            ans = Math.max(ans, deep);
            return;
        }
        maxDepth(root.left, deep + 1);
        maxDepth(root.right, deep + 1);
    }
}

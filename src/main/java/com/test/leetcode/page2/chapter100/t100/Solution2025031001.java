package com.test.leetcode.page2.chapter100.t100;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 16:28
 * @Version: 1.0
 */
public class Solution2025031001 {

    /**
     * 呃，总算碰到了一道简单题
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}

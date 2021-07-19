package com.test.leetcode.chapter100.t100;

import com.test.leetcode.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-01-13 16:54
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null)
                return true;
            return false;
        }
        if (q == null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

package com.test.leetcode.page2.chapter100.t100;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 16:30
 * @Version: 1.0
 */
public class Solution20230116 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}

package com.test.leetcode.page5.chapter400.t404;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 09:52
 * @Version: 1.0
 */
public class Solution20230525 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了66.35%的用户
     * 通过测试用例：100 / 100
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && left) {
            return root.val;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}

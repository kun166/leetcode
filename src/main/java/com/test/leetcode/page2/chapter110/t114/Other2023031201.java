package com.test.leetcode.page2.chapter110.t114;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Other2023031201
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 09:38
 * @Version: 1.0
 */
public class Other2023031201 {

    TreeNode preNode;

    /**
     * 呃，不知道说什么
     * <p>
     * 这种遍历方式，刚好和题目中的前序遍历是相反的
     * <p>
     * 所以preNode记录的刚好是前序遍历的当前节点的后一个节点……
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        /**
         * 先右节点
         */
        flatten(root.right);
        /**
         * 再左节点
         */
        flatten(root.left);
        /**
         * 再父节点
         */
        root.left = null;
        root.right = preNode;
        preNode = root;
    }
}

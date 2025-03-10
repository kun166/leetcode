package com.test.leetcode.page1.chapter90.t98;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 14:51
 * @Version: 1.0
 */
public class Solution2025031001 {

    /**
     * 递归的方式
     * 如果是左子树:
     * <p>
     * 如果是右子树
     * <p>
     * 0ms 击败100.00%
     * 42.43MB 击败66.73%
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 左侧最小的树
     * 右侧最大的树
     *
     * @param root
     * @param left
     * @param right
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return true;
        if (left != null && root.val <= left.val)
            return false;
        if (right != null && root.val >= right.val)
            return false;
        // 向左的话,把当前节点当做right传递进去。向右的话，把当前节点做left传进去
        return isValidBST(root.left, left, root) && isValidBST(root.right, root, right);
    }
}

package com.test.leetcode.page1.chapter90.t98;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OfficialFirst20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 14:12
 * @Version: 1.0
 */
public class OfficialFirst20230116 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
     * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * 它的左右子树也为二叉搜索树。
     *
     * @param node  当前节点
     * @param lower 当前树的最小值
     * @param upper 当前树的最大值
     * @return
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}

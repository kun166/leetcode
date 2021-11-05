package com.test.leetcode.page1.chapter90.t98;

import com.test.leetcode.TreeNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-10 19:28
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * @param root  当前节点
     * @param left  root节点归属于left的右子树
     * @param right root节点归属于right的左子树
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            // 如果当前节点为null,则为叶子节点，必定为true
            return true;
        if (root.left != null && root.left.val >= root.val)
            // 如果左子树不为空，且左子树节点值不小于当前节点值。则为false
            return false;
        if (root.left != null && left != null && root.left.val <= left.val)
            // 如果当前节点的左子树不为空，且当前节点归于某个节点的右子树，则该左子树的值应该大于某个节点的值
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;
        if (root.right != null && right != null && root.right.val >= right.val)
            return false;
        // left
        return isValidBST(root.left, left, root) && isValidBST(root.right, root, right);
    }
}

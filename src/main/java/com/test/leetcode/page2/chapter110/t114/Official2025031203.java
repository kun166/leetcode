package com.test.leetcode.page2.chapter110.t114;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Official2025031203
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 09:51
 * @Version: 1.0
 */
public class Official2025031203 {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                /**
                 * 如果有左子树
                 */
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    /**
                     * 找出左子树的最后一个节点
                     */
                    predecessor = predecessor.right;
                }
                /**
                 * 左子树最后一个节点的的右子树指向当前节点的右节点
                 * 这一步牛啊
                 */
                predecessor.right = curr.right;
                curr.left = null;
                /**
                 * 当前节点的右子树指向下一个节点
                 */
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}

package com.test.leetcode.page2.chapter100.t105;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 09:12
 * @Version: 1.0
 */
public class Solution2025031101 {

    /**
     * 只能说尝试下
     * <p>
     * 3ms 击败38.70%
     * 43.21MB 击败96.55%
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0);
    }

    /**
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @param left     inorder的左边界
     * @param right    inorder的右边界
     * @param index    preorder中根节点的下标
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder, int left, int right, int index) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[index]) {
                node.left = buildTree(preorder, inorder, left, i - 1, index + 1);
                node.right = buildTree(preorder, inorder, i + 1, right, index + 1 + i - left);
                break;
            }
        }
        return node;
    }
}

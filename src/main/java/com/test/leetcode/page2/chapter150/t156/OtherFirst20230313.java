package com.test.leetcode.page2.chapter150.t156;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OtherFrist20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 10:03
 * @Version: 1.0
 */
public class OtherFirst20230313 {

    // 题目有两点信息：
    // 1.所有的右节点都有左兄弟节点
    // 2.所有的右节点都是叶子节点
    // DFS递归版本：
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        // 将root认为是空树的左子树
        return dfs(null, root);
    }

    /**
     * @param x y的父节点
     * @param y 当前要处理的节点
     * @return
     */
    private TreeNode dfs(TreeNode x, TreeNode y) {
        // 先找到要返回的根节点：
        // 1) y没有左子树了，说明y是最左边了，它就是最终要返回的根节点
        // 2) y左边还有子节点，说明根节点还要往下扎才能找到，左边下去递归
        TreeNode newRoot = y.left == null ? y : dfs(y, y.left);
        // 父节点不为空，按照题目要求修改
        if (x != null) {
            // z是x的右孩子
            TreeNode z = x.right;
            // y的左指针指向z
            y.left = z;
            // y的右指针指向x
            y.right = x;
            // 将x的左右指针置空，否则可能出现环
            // 当当前子节点y处理结束之后,父节点x会重新初始化左右子节点
            x.left = x.right = null;
        }
        return newRoot; // 返回根节点，到上一层继续修改
    }
}

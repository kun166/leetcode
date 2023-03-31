package com.test.leetcode.page3.chapter280.t285;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OfficialSecond20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 09:47
 * @Version: 1.0
 */
public class OfficialSecond20230331 {

    /**
     * 方法二：利用二叉搜索树的性质
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        // 如果有右子树，则右子树的最左子树肯定就是所寻找
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        // 没有右子树
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                // 如果当前节点值大于p的值，则寻找的那个节点一定存在，起码当前节点就可能是。
                // 寻找当前节点的渐进逼近值
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }
}

package com.test.leetcode.page3.chapter280.t285;

import com.test.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 09:13
 * @Version: 1.0
 */
public class SolutionFirst20230331 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了49.80%的用户
     * 通过测试用例：24 / 24
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 有右子树
        if (p.right != null) {
            TreeNode left = p.right;
            while (left.left != null) {
                left = left.left;
            }
            return left;
        }
        // 没有右子树
        // 从原树中，确定p是根节点，还是父节点的左子树还是右子树。
        // 如果是左子树，则返回父节点
        // 如果是右子树，则返回null
        if (root == p) {
            // 根节点
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                if (root == p) {
                    return deque.pop();
                }
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            root = root.right;
            if (root == p) {
                if (deque.isEmpty()) {
                    return null;
                }
                return deque.pop();
            }
        }
        return null;
    }
}

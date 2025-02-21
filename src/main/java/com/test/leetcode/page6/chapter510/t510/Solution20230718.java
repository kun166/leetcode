package com.test.leetcode.page6.chapter510.t510;

/**
 * @ClassName: Solution20230718
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/18 07:38
 * @Version: 1.0
 */
public class Solution20230718 {

    /**
     * 执行用时：32 ms, 在所有 Java 提交中击败了98.41%的用户
     * 内存消耗：43.2 MB, 在所有 Java 提交中击败了26.98%的用户
     * 通过测试用例：26 / 26
     *
     * @param node
     * @return
     */
    public Node inorderSuccessor(Node node) {
        if (node.parent == null) {
            // 它就是root
            Node right = node.right;
            if (right == null) {
                return null;
            }
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        if (node.val < node.parent.val) {
            // 当前节点为父节点的左子树
            if (node.right != null) {
                // 当前节点的右子树不为空
                Node right = node.right;
                while (right.left != null) {
                    right = right.left;
                }
                return right;
            }
            return node.parent;
        }
        // 当前节点为父节点的右子树，这个就比较麻烦了
        if (node.right != null) {
            // 当前节点的右子树不为空
            Node right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        Node parent = node.parent;
        while (parent != null) {
            if (parent.val > node.val) {
                return parent;
            }
            parent = parent.parent;
        }
        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

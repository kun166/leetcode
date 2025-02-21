package com.test.leetcode.page6.chapter510.t510;

/**
 * @ClassName: Official20230718
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/18 07:59
 * @Version: 1.0
 */
public class Official20230718 {

    /**
     * 中序遍历的后继，牛啊
     *
     * @param x
     * @return
     */
    public Node inorderSuccessor(Node x) {
        // the successor is somewhere lower in the right subtree
        if (x.right != null) {
            x = x.right;
            while (x.left != null)
                x = x.left;
            return x;
        }

        // the successor is somewhere upper in the tree
        while (x.parent != null && x == x.parent.right)
            x = x.parent;
        return x.parent;
    }
}

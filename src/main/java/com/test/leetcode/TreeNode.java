package com.test.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-04 18:01
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

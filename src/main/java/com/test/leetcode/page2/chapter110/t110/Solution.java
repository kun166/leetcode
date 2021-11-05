package com.test.leetcode.page2.chapter110.t110;

import com.test.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-05-20 15:13
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean balance = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                if (!balance) return false;
                queue.offer(node.right);
            }

            if (node.left != null) {
                if (!balance) return false;
                queue.offer(node.left);
            }

            if (node.right == null || node.left == null) {
                balance = false;
            }
        }
        return true;
    }
}

package com.test.leetcode.page2.chapter120.t129;

import com.test.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230128
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 15:49
 * @Version: 1.0
 */
public class OfficialSecond20230128 {

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        // 顶部拉取，底部加入，层序遍历
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            // 从顶部拉取
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                // 这个判断条件说明是叶子节点了
                sum += num;
            } else {
                if (left != null) {
                    // 从底部加入
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    // 从底部加入
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}

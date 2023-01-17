package com.test.leetcode.page2.chapter110.t113;

import com.test.leetcode.TreeNode;

import java.util.*;

/**
 * @ClassName: Solution20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 16:15
 * @Version: 1.0
 */
public class Solution20230117 {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, ans, new LinkedList<>());
        return ans;
    }

    /**
     * 递归回溯
     *
     * @param root
     * @param targetSum
     * @param ans
     * @param deque
     */
    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> ans, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            deque.offer(root.val);
            ans.add(new ArrayList<>(deque));
            deque.pollLast();
            return;
        }
        deque.offer(root.val);
        pathSum(root.left, targetSum - root.val, ans, deque);
        pathSum(root.right, targetSum - root.val, ans, deque);
        deque.pollLast();
    }
}

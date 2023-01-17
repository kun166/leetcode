package com.test.leetcode.page2.chapter100.t107;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 14:33
 * @Version: 1.0
 */
public class Solution20230117 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        TreeNode node;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = deque.size();
            while (count > 0) {
                node = deque.pop();
                list.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                count--;
            }
            ans.add(0, list);
        }
        return ans;
    }
}

package com.test.leetcode.page2.chapter140.t144;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-29 20:27
 */
public class SolutionSecond {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            root = root.right;
        }
        return list;
    }
}

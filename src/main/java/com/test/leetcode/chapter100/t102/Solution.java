package com.test.leetcode.chapter100.t102;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-01-13 20:02
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        levelOrder(ans, nodeList);
        return ans;
    }

    public void levelOrder(List<List<Integer>> ans, LinkedList<TreeNode> nodeList) {
        int size = nodeList.size();
        List<Integer> valueList = new ArrayList<>();
        int index = 0;
        while (index < size) {
            TreeNode node = nodeList.poll();
            if (node != null) {
                valueList.add(node.val);
                nodeList.offer(node.left);
                nodeList.offer(node.right);
            }
            index++;
        }
        if (valueList.size() > 0) {
            ans.add(valueList);
            levelOrder(ans, nodeList);
        }
    }
}

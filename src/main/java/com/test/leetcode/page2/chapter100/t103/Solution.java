package com.test.leetcode.page2.chapter100.t103;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-04-19 10:25
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sum = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        zigzagLevelOrder(nodeList, true, sum);
        return sum;
    }

    public void zigzagLevelOrder(List<TreeNode> nodeList, boolean fromLeftToRirght, List<List<Integer>> sum) {
        List<TreeNode> nextNodeList = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (TreeNode node : nodeList) {
            l.add(node.val);

        }
    }
}

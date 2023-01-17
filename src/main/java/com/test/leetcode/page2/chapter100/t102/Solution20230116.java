package com.test.leetcode.page2.chapter100.t102;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: Solution20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 17:32
 * @Version: 1.0
 */
public class Solution20230116 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            ans.add(list.stream().map(node -> node.val).collect(Collectors.toList()));
            List<TreeNode> pre = list;
            list = new ArrayList<>();
            for (TreeNode node : pre) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return ans;
    }
}

package com.test.leetcode.page2.chapter100.t102;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 17:05
 * @Version: 1.0
 */
public class Solution2025031001 {

    /**
     * 执行用时分布 4ms 击败0.81%
     * 44.04MB 击败82.18%
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<TreeNode> first = new ArrayList<>();
        first.add(root);
        List<TreeNode> second;
        while (!first.isEmpty()) {
            second = new ArrayList<>();
            for (TreeNode node : first) {
                if (node.left != null)
                    second.add(node.left);
                if (node.right != null)
                    second.add(node.right);
            }
            ans.add(first.stream().map(n -> n.val).collect(Collectors.toList()));
            first = second;
        }
        return ans;
    }
}

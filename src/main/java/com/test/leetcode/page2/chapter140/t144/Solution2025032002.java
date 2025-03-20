package com.test.leetcode.page2.chapter140.t144;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025032002
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 15:26
 * @Version: 1.0
 */
public class Solution2025032002 {

    /**
     * 迭代
     * 0ms	击败100.00%
     * 40.96MB	击败39.47%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        while (root != null || !ll.isEmpty()) {
            while (root != null) {
                ll.push(root);
                ans.add(root.val);
                root = root.left;
            }
            TreeNode node = ll.pop();
            root = node.right;
        }
        return ans;
    }
}

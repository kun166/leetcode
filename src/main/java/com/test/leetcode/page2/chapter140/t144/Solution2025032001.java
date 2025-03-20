package com.test.leetcode.page2.chapter140.t144;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 15:21
 * @Version: 1.0
 */
public class Solution2025032001 {

    /**
     * 呃，先来个无脑递归吧……
     * 0ms	击败100.00%
     * 40.71MB	击败99.49%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }

    public void preorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }
}

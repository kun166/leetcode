package com.test.leetcode.page2.chapter110.t113;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 16:29
 * @Version: 1.0
 */
public class Solution2025031101 {

    /**
     * 递归-回溯啊
     * <p>
     * 1ms 击败99.81%
     * 43.68MB 击败80.10%
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(root, targetSum, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            List<Integer> l = new ArrayList<>(list);
            l.add(root.val);
            ans.add(l);
            return;
        }

        // 选择左子树
        list.add(root.val);
        backtrack(root.left, targetSum - root.val, ans, list);
        // 右子树
        backtrack(root.right, targetSum - root.val, ans, list);
        list.remove(list.size() - 1);
    }
}

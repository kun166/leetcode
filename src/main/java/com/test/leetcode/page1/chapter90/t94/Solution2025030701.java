package com.test.leetcode.page1.chapter90.t94;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 16:05
 * @Version: 1.0
 */
public class Solution2025030701 {

    /**
     * 先来个简单的递归吧
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}

package com.test.leetcode.page1.chapter90.t94;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230104
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/4 08:42
 * @Version: 1.0
 */
public class SolutionFirst20230104 {

    /**
     * 先来一个递归吧
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
        // 先左
        inorderTraversal(root.left, list);
        // 中
        list.add(root.val);
        // 右
        inorderTraversal(root.right, list);
    }
}

package com.test.leetcode.page2.chapter140.t144;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SolutionFirst20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 18:15
 * @Version: 1.0
 */
public class SolutionFirst20230202 {

    /**
     * 先来个简单的递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}

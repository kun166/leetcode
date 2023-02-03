package com.test.leetcode.page2.chapter140.t145;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230203
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/3 08:22
 * @Version: 1.0
 */
public class SolutionFirst20230203 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    /**
     * 递归
     *
     * @param root
     * @param list
     */
    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }
}

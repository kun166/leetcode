package com.test.leetcode.page3.chapter230.t230;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230308
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/8 08:52
 * @Version: 1.0
 */
public class Solution20230308 {

    boolean find = false;

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest(root, k, list);
        return list.get(k - 1);
    }

    public void kthSmallest(TreeNode root, int k, List<Integer> list) {
        if (find || root == null) {
            return;
        }
        kthSmallest(root.left, k, list);
        list.add(root.val);
        if (list.size() == k) {
            find = true;
        }
        kthSmallest(root.right, k, list);
    }
}

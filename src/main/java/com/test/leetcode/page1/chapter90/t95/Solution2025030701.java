package com.test.leetcode.page1.chapter90.t95;

import com.test.leetcode.TreeNode;

import java.util.List;

/**
 * @ClassName: Solution2025030701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 17:49
 * @Version: 1.0
 */
public class Solution2025030701 {

    public List<TreeNode> generateTrees(int n) {

    }


    public void generateTrees(boolean[] use, TreeNode parent, List<TreeNode> list, int index) {
        if (index == use.length) {
            list.add(parent);
            return;
        }

        for (int i = 1; i < parent.val; i++) {
            // 左子树
            use[i - 1] = true;
            parent.left = new TreeNode(i);
            generateTrees(use, parent.left, list, index + 1);
            parent.left = null;
        }
    }
}

package com.test.leetcode.page3.chapter220.t222;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230228
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/28 11:03
 * @Version: 1.0
 */
public class Solution20230228 {


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.right) + countNodes(root.left) + 1;
    }
}

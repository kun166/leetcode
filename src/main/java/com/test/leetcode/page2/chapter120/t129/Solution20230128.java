package com.test.leetcode.page2.chapter120.t129;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230128
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 15:34
 * @Version: 1.0
 */
public class Solution20230128 {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int num) {
        num = num * 10 + root.val;
        int left = root.left != null ? sumNumbers(root.left, num) : 0;
        int right = root.right != null ? sumNumbers(root.right, num) : 0;
        return left + right != 0 ? left + right : num;
    }
}

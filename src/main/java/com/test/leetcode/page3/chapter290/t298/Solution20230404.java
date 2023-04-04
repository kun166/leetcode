package com.test.leetcode.page3.chapter290.t298;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 11:12
 * @Version: 1.0
 */
public class Solution20230404 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.35%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了57.52%的用户
     * 通过测试用例：53 / 53
     *
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, null, 0);
    }

    public int longestConsecutive(TreeNode root, Integer value, int length) {
        if (root == null) {
            return length;
        }
        int m, l, r;
        if (value != null && value.equals(root.val - 1)) {
            m = length + 1;
        } else {
            m = 1;
        }
        l = longestConsecutive(root.left, root.val, m);
        r = longestConsecutive(root.right, root.val, m);
        return Math.max(Math.max(m, length), Math.max(l, r));
    }
}

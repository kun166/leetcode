package com.test.leetcode.page6.chapter510.t513;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230718
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/18 09:02
 * @Version: 1.0
 */
public class Solution20230718 {

    int ans;
    int maxLevel;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了18.25%的用户
     * 通过测试用例：77 / 77
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }

    public void findBottomLeftValue(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            ans = root.val;
            maxLevel = level;
        }
        findBottomLeftValue(root.left, level + 1);
        findBottomLeftValue(root.right, level + 1);

    }
}

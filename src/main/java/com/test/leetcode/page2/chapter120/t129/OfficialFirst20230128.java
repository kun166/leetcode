package com.test.leetcode.page2.chapter120.t129;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Official20230128
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 15:46
 * @Version: 1.0
 */
public class OfficialFirst20230128 {

    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

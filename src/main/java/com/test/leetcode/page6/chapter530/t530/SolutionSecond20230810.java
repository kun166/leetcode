package com.test.leetcode.page6.chapter530.t530;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: SolutionSecond20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 10:26
 * @Version: 1.0
 */
public class SolutionSecond20230810 {

    int ans = Integer.MAX_VALUE;

    /**
     * 利用二叉树，左子树<root<右子树的特性
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了52.80%的用户
     * 通过测试用例：189 / 189
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference(root, null, null);
        return ans;
    }

    public void getMinimumDifference(TreeNode cur, Integer leftValue, Integer rightValue) {
        if (ans == 0) {
            return;
        }
        if (cur.left != null) {
            ans = Math.min(ans, Math.abs(cur.val - cur.left.val));
            if (leftValue != null) {
                ans = Math.min(ans, Math.abs(leftValue - cur.left.val));
            }
            getMinimumDifference(cur.left, leftValue, cur.val);
        }
        if (cur.right != null) {
            ans = Math.min(ans, Math.abs(cur.val - cur.right.val));
            if (rightValue != null) {
                ans = Math.min(ans, Math.abs(rightValue - cur.right.val));
            }
            getMinimumDifference(cur.right, cur.val, rightValue);
        }
    }
}

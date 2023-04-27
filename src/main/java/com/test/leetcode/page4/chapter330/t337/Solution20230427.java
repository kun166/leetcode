package com.test.leetcode.page4.chapter330.t337;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230427
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/27 09:29
 * @Version: 1.0
 */
public class Solution20230427 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了76.45%的用户
     * 通过测试用例：124 / 124
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        Result result = robResult(root);
        return Math.max(result.noRobAmount, result.robAmount);
    }


    public Result robResult(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        Result left = robResult(root.left);
        Result right = robResult(root.right);
        // 本次偷
        int robAmount = left.noRobAmount + right.noRobAmount + root.val;
        // 本次不偷
        int noRobAmount = Math.max(Math.max(left.noRobAmount + right.noRobAmount, left.robAmount + right.robAmount),
                Math.max(left.noRobAmount + right.robAmount, left.robAmount + right.noRobAmount));
        return new Result(robAmount, noRobAmount);
    }

    /**
     * 呃，官方返回的是一个二维数组，更好
     */
    class Result {
        int robAmount;
        int noRobAmount;

        Result(int robAmount, int noRobAmount) {
            this.robAmount = robAmount;
            this.noRobAmount = noRobAmount;
        }
    }
}

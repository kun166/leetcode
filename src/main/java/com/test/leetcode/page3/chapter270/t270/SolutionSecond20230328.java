package com.test.leetcode.page3.chapter270.t270;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: SolutionSecond20230328
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/28 09:26
 * @Version: 1.0
 */
public class SolutionSecond20230328 {

    /**
     * 自底向上
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了44.49%的用户
     * 通过测试用例：63 / 63
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = closestValue(root.left, target);
        int right = closestValue(root.right, target);
        int ans = Math.abs(left - target) > Math.abs(right - target) ? right : left;
        ans = Math.abs(ans - target) > Math.abs(root.val - target) ? root.val : ans;
        return ans;
    }
}

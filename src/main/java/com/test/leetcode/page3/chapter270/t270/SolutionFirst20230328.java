package com.test.leetcode.page3.chapter270.t270;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: SolutionFirst20230328
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/28 09:15
 * @Version: 1.0
 */
public class SolutionFirst20230328 {

    private double ans = Integer.MAX_VALUE;

    /**
     * 自根节点向下
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了35.36%的用户
     * 通过测试用例：63 / 63
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        find(root, target);
        return (int) ans;
    }

    public void find(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(ans - target) > Math.abs(root.val - target)) {
            ans = root.val;
        }
        find(root.left, target);
        find(root.right, target);
    }
}

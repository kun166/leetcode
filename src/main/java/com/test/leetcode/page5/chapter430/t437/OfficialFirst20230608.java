package com.test.leetcode.page5.chapter430.t437;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OfficialFirst20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 15:44
 * @Version: 1.0
 */
public class OfficialFirst20230608 {

    /**
     * 呃，这……双层递归啊
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}

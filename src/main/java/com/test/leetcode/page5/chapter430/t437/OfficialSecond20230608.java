package com.test.leetcode.page5.chapter430.t437;

import com.test.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: OfficialSecond20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 07:39
 * @Version: 1.0
 */
public class OfficialSecond20230608 {

    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        // 在没有任何元素的情况下，前缀和0出现了1次
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    /**
     * 呃，这个地方进行了递归回溯
     *
     * @param root      当前二叉树节点
     * @param prefix    前缀和
     * @param curr      当前累加值
     * @param targetSum 目标值
     * @return
     */
    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        // 前缀和
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        // 将当前值curr的值+1
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        // 将当前值curr的值-1。进行了回溯
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}

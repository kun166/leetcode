package com.test.leetcode.page6.chapter530.t530;

import com.test.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 10:18
 * @Version: 1.0
 */
public class Solution20230810 {

    int ans = Integer.MAX_VALUE;

    /**
     * 执行用时：484 ms, 在所有 Java 提交中击败了5.90%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了17.43%的用户
     * 通过测试用例：189 / 189
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference(root, new HashSet<>());
        return ans;
    }

    public void getMinimumDifference(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        for (int i : set) {
            ans = Math.min(ans, Math.abs(i - root.val));
        }
        set.add(root.val);
        getMinimumDifference(root.right, set);
        getMinimumDifference(root.left, set);
    }
}

package com.test.leetcode.page6.chapter500.t508;

import com.test.leetcode.TreeNode;

import java.util.*;

/**
 * @ClassName: Solution20230717
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/17 10:17
 * @Version: 1.0
 */
public class Solution20230717 {

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了81.95%的用户
     * 内存消耗：43.2 MB, 在所有 Java 提交中击败了18.04%的用户
     * 通过测试用例：58 / 58
     *
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        treeSum(root);
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            } else if (entry.getValue() > maxCount) {
                list.clear();
                list.add(entry.getKey());
                maxCount = entry.getValue();
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int current = treeSum(root.left) + treeSum(root.right) + root.val;
        map.put(current, map.getOrDefault(current, 0) + 1);
        return current;
    }
}

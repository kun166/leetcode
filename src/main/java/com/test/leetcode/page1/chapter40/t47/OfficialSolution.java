package com.test.leetcode.page1.chapter40.t47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-29 14:31
 */
public class OfficialSolution {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        //先排序
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    /**
     * @param nums 原数组
     * @param ans  返回结果
     * @param idx  游标
     * @param perm 存放游标之前的数组
     */
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            // 如果游标等于数组长度，则将perm添加到返回结果里
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 遍历数组
            // vis[i]标识ans[i]是否被使用过。nums[i] == nums[i - 1]标识当前数组位置的元素与前一个位置的元素相等。
            // 保持相等的元素的前后位置不变。
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}

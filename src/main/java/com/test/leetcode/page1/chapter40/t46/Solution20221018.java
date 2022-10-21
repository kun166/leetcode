package com.test.leetcode.page1.chapter40.t46;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221018
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/18 16:31
 * @Version: 1.0
 */
public class Solution20221018 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public void permute(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] use) {
        if (nums.length == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] == true) {
                continue;
            }
            list.add(nums[i]);
            use[i] = true;
            permute(nums, ans, list, use);
            list.remove(list.size() - 1);
            use[i] = false;
        }
    }
}

package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution20221111 {

    @Test
    public void test() {
        System.out.println(JSON.toJSON(permute(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] use = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, new ArrayList<>(), use);
        return ans;
    }

    public void permute(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] use) {
        if (nums.length == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!use[i]) {
                use[i] = true;
                list.add(nums[i]);
                permute(nums, ans, list, use);
                use[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}

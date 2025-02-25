package com.test.leetcode.page1.chapter40.t47;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution2025022501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 11:34
 * @Version: 1.0
 */
public class Solution2025022501 {


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permuteUnique(new int[]{1, 1, 2})));
    }

    /**
     * 凡是涉及到排除重复数的，那就得排序
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        backtrack(nums, use, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, boolean[] use, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (use[i]) {
                // 已经挑选过了,跳过
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) {
                continue;
            }
            use[i] = true;
            list.add(nums[i]);
            backtrack(nums, use, ans, list);
            use[i] = false;
            list.remove(list.size() - 1);
        }
    }

}

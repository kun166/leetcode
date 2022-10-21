package com.test.leetcode.page1.chapter40.t47;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20221018
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/18 15:38
 * @Version: 1.0
 */
public class Solution20221018 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permuteUnique(new int[]{1, 1, 2})));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ant = new ArrayList<>();
        permuteUnique(nums, ant, new ArrayList<>(), new boolean[nums.length]);
        return ant;
    }

    public void permuteUnique(int[] nums, List<List<Integer>> ant, List<Integer> list, boolean[] use) {
        if (nums.length == list.size()) {
            ant.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] == true) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && use[i - 1] == false) {
                continue;
            }
            list.add(nums[i]);
            use[i] = true;
            permuteUnique(nums, ant, list, use);
            list.remove(list.size() - 1);
            use[i] = false;
        }
    }
}

package com.test.leetcode.page1.chapter40.t47;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20220319
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/19 16:19
 * @Version: 1.0
 */
public class Solution20220319 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permuteUnique(new int[]{1, 1, 2})));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ant = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permuteUnique(nums, ant, list, 0);
        return ant;
    }

    public void permuteUnique(int[] nums, List<List<Integer>> ant, List<Integer> list, int index) {
        if (list.size() == nums.length) {
            ant.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= index; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(i, nums[index]);
            permuteUnique(nums, ant, list, index + 1);
            list.remove(i);
        }
    }
}

package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221014
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/14 17:43
 * @Version: 1.0
 */
public class Solution20221014 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permute(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ant = new ArrayList<>();
        permute(nums, ant, 0);
        return ant;
    }

    public void permute(int[] nums, List<List<Integer>> ant, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (Integer number : nums) {
                list.add(number);
            }
            ant.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, ant, index + 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int p1, int p2) {
        int mid = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = mid;
    }
}

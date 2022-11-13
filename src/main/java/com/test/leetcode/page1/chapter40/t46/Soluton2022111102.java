package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soluton2022111102 {

    @Test
    public void test() {
        System.out.println(JSON.toJSON(permute(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, 0);
        return ans;
    }

    public void permute(int[] nums, List<List<Integer>> ans, int index) {
        if (nums.length == index) {
            List<Integer> list = new ArrayList<>();
            for (int number : nums) {
                list.add(number);
            }
            ans.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, ans, index + 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int src, int desc) {
        int mid = nums[src];
        nums[src] = nums[desc];
        nums[desc] = mid;
    }

}

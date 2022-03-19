package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20220319
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/19 09:54
 * @Version: 1.0
 */
public class Solution20220319 {
    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permute(new int[]{1, 2, 3})));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ant = new ArrayList<>();
        permute(nums, ant, new ArrayList<>());
        return ant;
    }

    public void permute(int[] nums, List<List<Integer>> ant, List<Integer> list) {
        if (list.size() == nums.length) {
            ant.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (list.contains(number)) {
                continue;
            }
            list.add(number);
            permute(nums, ant, list);
            list.remove(list.size() - 1);
        }
    }
}

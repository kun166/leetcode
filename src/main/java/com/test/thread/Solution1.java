package com.test.thread;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-02 18:52
 */
public class Solution1 {

    @Test
    public void test() {
        List<List<Integer>> ans = subsetsWithDup(new int[]{1, 2, 3});
        System.out.println(JSON.toJSONString(ans));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        subsetsWithDup(ans, list, nums, used);
        return ans;
    }

    public void subsetsWithDup(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            list.add(nums[i]);
            subsetsWithDup(ans, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

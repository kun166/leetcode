package com.test.leetcode.page1.chapter90.t90;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-02 17:50
 */
public class Solution {

    @Test
    public void test() {
        List<List<Integer>> ans = subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(JSON.toJSONString(ans));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        subsetsWithDup(ans, list, nums, used, 0);
        return ans;
    }

    public void subsetsWithDup(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] used, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            subsetsWithDup(ans, list, nums, used, i + 1);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

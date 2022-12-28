package com.test.leetcode.page1.chapter90.t90;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 08:33
 * @Version: 1.0
 */
public class Solution20221228 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(subsetsWithDup(new int[]{1, 2, 2})));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        ans.add(new ArrayList<>(list));
        subsetsWithDup(nums, ans, list, 0);
        return ans;
    }

    public void subsetsWithDup(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            subsetsWithDup(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

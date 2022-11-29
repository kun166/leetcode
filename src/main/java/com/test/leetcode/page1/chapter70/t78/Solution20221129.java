package com.test.leetcode.page1.chapter70.t78;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221129
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/29 20:50
 * @Version: 1.0
 */
public class Solution20221129 {
    @Test
    public void test() {
        System.out.println(JSON.toJSONString(subsets(new int[]{0})));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        ans.add(new ArrayList<>(list));
        for (int i = 1; i <= nums.length; i++) {
            subsets(nums, i, ans, list, 0);
        }
        return ans;
    }

    public void subsets(int[] nums, int k, List<List<Integer>> ans, List<Integer> list, int index) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (list.size() + (nums.length - index) < k) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, k, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

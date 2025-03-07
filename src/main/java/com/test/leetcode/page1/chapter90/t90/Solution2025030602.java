package com.test.leetcode.page1.chapter90.t90;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution2025030602
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 17:11
 * @Version: 1.0
 */
public class Solution2025030602 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(subsetsWithDup(new int[]{1, 2, 2})));
    }

    /**
     * 组合容易，排列难啊
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        ans.add(new ArrayList<>(list));
        backtrack(nums, ans, new ArrayList<>(), 0, true);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> list, int index, boolean chose) {
        if (index == nums.length)
            return;
        // 选择当前下标的数
        if (chose || (index > 0 && nums[index] != nums[index - 1])) {
            list.add(nums[index]);
            ans.add(new ArrayList<>(list));
            backtrack(nums, ans, list, index + 1, true);
            list.remove(list.size() - 1);
        }

        // 不选
        backtrack(nums, ans, list, index + 1, false);
    }
}

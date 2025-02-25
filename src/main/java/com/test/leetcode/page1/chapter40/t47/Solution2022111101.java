package com.test.leetcode.page1.chapter40.t47;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2022111101 {

    @Test
    public void test() {
        //System.out.println(JSON.toJSONString(permuteUnique(new int[]{0, 0, 0, 1, 9})));
        System.out.println(JSON.toJSONString(permuteUnique(new int[]{1, 1, 2})));
    }

    /**
     * 这个解法是错误的……
     * 输入：[0,1,0,0,9]
     * 输出：[[0,0,0,1,9],[0,0,0,9,1],[0,0,1,0,9],[0,0,1,9,0],[0,0,9,1,0],[0,0,9,0,1],[0,1,0,0,9],[0,1,0,9,0],[0,1,9,0,0],[0,9,0,1,0],[0,9,0,0,1],[0,9,1,0,0],[0,9,0,1,0],[0,9,0,0,1],[1,0,0,0,9],[1,0,0,9,0],[1,0,9,0,0],[1,9,0,0,0],[9,0,0,1,0],[9,0,0,0,1],[9,0,1,0,0],[9,0,0,1,0],[9,0,0,0,1],[9,1,0,0,0],[9,0,0,1,0],[9,0,0,0,1],[9,0,1,0,0],[9,0,0,1,0],[9,0,0,0,1]]
     * 预期结果：[[0,0,0,1,9],[0,0,0,9,1],[0,0,1,0,9],[0,0,1,9,0],[0,0,9,0,1],[0,0,9,1,0],[0,1,0,0,9],[0,1,0,9,0],[0,1,9,0,0],[0,9,0,0,1],[0,9,0,1,0],[0,9,1,0,0],[1,0,0,0,9],[1,0,0,9,0],[1,0,9,0,0],[1,9,0,0,0],[9,0,0,0,1],[9,0,0,1,0],[9,0,1,0,0],[9,1,0,0,0]]
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        permuteUnique(nums, ans, 0);
        return ans;
    }

    public void permuteUnique(int[] nums, List<List<Integer>> ans, int index) {
        if (nums.length == index) {
            List<Integer> list = new ArrayList<>();
            for (int number : nums) {
                list.add(number);
            }
            ans.add(list);
            return;
        }
        // 1,1,2
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            swap(nums, i, index);
            permuteUnique(nums, ans, index + 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int src, int desc) {
        int mid = nums[src];
        nums[src] = nums[desc];
        nums[desc] = mid;
    }
}

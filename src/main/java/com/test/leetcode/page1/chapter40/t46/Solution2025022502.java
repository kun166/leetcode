package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025022502
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 10:58
 * @Version: 1.0
 */
public class Solution2025022502 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permute(new int[]{1, 2, 3})));
    }

    /**
     * 这种方式出不来结果……
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, 0);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            ans.add(list);
            return;
        }
        /**
         * 下面的换或者不换，一共会出现2的数组长度次方个
         * 比如数组是{1,2,3},则会有2的3次方个组合,
         * 这显然和排列是不相符的
         */
        // 换
        swap(nums, index, 0);
        backtrack(nums, ans, index + 1);
        swap(nums, 0, index);
        // 不换
        backtrack(nums, ans, index + 1);
    }

    public void swap(int[] nums, int left, int right) {
        if (left == right)
            return;
        int mid = nums[left];
        nums[left] = nums[right];
        nums[right] = mid;
    }
}

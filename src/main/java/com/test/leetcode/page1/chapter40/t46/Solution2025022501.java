package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20250225
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 10:26
 * @Version: 1.0
 */
public class Solution2025022501 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permute(new int[]{1, 2, 3})));
    }

    /**
     * 感觉递归回溯会比较容易实现
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
         * index从0到数组长度,拿{1,2,3}来说,当index为0,1,2的时候可以执行下面循环
         * 当index为0的时候,可以循环3次,
         * 当index为1的时候,可以循环2次
         * 当index为2的时候，可以循环1次
         *
         * 3乘以2乘以1，就是3的阶乘，和排列数是一致的
         *
         *
         * 当index为0的时候,下面循环会将数组的每一个数和0的位置互换,
         * 然后数组中的每一个数都可以位于第一位
         *
         * 当index为1的时候,第0位的数字已经不需要交换的，只需要交换下标为1和1之后的数字就行了
         */
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrack(nums, ans, index + 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int left, int right) {
        if (left == right)
            return;
        int mid = nums[left];
        nums[left] = nums[right];
        nums[right] = mid;
    }


}

package com.test.leetcode.page5.chapter440.t442;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 15:56
 * @Version: 1.0
 */
public class OfficialFirst20230609 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
    }

    /**
     * 方法一：将元素交换到对应的位置
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 这个while不会死循环么？
            while (nums[i] != nums[nums[i] - 1]) {
                // 这个while真的是牛逼。如果当前i位置上的数，所在的下标，不是正确的，则把当前数移到正确位置
                // 如果所在的下标已经是正确的了，则说明是重复数(跳出循环)
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    /**
     * 把nums中的第index1个位置和第index2位置的数互换位置
     *
     * @param nums
     * @param index1
     * @param index2
     */
    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

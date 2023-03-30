package com.test.leetcode.page3.chapter280.t280;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230330
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/30 09:39
 * @Version: 1.0
 */
public class OfficialFirst20230330 {

    /**
     * 解法一：排序
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

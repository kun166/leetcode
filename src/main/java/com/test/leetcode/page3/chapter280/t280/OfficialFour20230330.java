package com.test.leetcode.page3.chapter280.t280;

/**
 * @ClassName: OfficialFour20230330
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/30 09:44
 * @Version: 1.0
 */
public class OfficialFour20230330 {

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

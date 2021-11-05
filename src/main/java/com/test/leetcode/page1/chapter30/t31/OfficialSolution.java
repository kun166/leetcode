package com.test.leetcode.page1.chapter30.t31;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-18 17:44
 */
public class OfficialSolution {

    /**
     * 神一样的解法啊。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 如果高位的数不小于低位的数，就继续找下一个
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 说明i后面的都是倒序排列
        if (i >= 0) {
            int j = nums.length - 1;
            // 既然是倒序排列，则从后向前找比nums[i]大的数，则它是比nums[i]大最少的数
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换位置
            swap(nums, i, j);
        }
        // 对i之后的数进行翻转
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

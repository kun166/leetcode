package com.test.leetcode.page2.chapter180.t189;

/**
 * @ClassName: OfficialThird20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 16:20
 * @Version: 1.0
 */
public class OfficialThird20230215 {

    /**
     * 数组翻转
     * <p>
     * 呃，牛逼plus，这都行？
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

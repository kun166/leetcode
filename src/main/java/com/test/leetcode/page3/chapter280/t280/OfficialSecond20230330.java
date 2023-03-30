package com.test.leetcode.page3.chapter280.t280;

/**
 * @ClassName: OfficialSecond20230330
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/30 09:40
 * @Version: 1.0
 */
public class OfficialSecond20230330 {

    /**
     * 一遍交换
     * <p>
     * 其实这题用数学归纳法很好证明：
     * 假设 [0,1, ..., k] 均已满足摆动排序，而 k+1 不满足，记此时 nums[k-1]，nums[k]，nums[k+1] 分别为 a，b，c
     * 若不满足的是降序，则可知：c>b，同时 b>=a，此时三个数状态是 a <= b < c，交换 b 和 c 后变成：a < c > b，满足小大小
     * 若不满足的是升序，则可知：c<b，同时 b<=a，此时三个数状态是 a >= b > c，交换 b 和 c 后变成：a > c < b，满足大小大
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

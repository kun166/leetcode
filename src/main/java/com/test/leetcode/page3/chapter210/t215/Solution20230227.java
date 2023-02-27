package com.test.leetcode.page3.chapter210.t215;

import org.junit.Test;

/**
 * @ClassName: Solution20230227
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/27 10:35
 * @Version: 1.0
 */
public class Solution20230227 {

    @Test
    public void test() {
        System.out.println(findKthLargest(new int[]{1}, 1));
    }

    /**
     * 这题试一下二分法？
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 从前找下标为k的那个值
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int l = left, r = left + 1;
            while (r <= right) {
                // 如果nums[r]>=nums[l],则不用管
                // 否则,互换位置？
                if (nums[l] > nums[r]) {
                    // 互换位置
                    int number = nums[l];
                    nums[l] = nums[r];
                    nums[r] = nums[l + 1];
                    nums[l + 1] = number;
                    l++;
                }
                // 第一次运行，这个地方忘了，导致死循环
                r++;
            }
            if (l == k) {
                return nums[l];
            } else if (l < k) {
                left = l + 1;
            } else {
                right = l - 1;
            }
        }
        // 提交运行，这个地方返回的是left，而非nums[left],第二次出错
        return nums[left];
    }
}

package com.test.leetcode.page1.chapter10.t16;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-20 12:47
 */
public class Solution20201020 {

    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int closestSum = Integer.MAX_VALUE, closestSumDif = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            int start = i + 1, end = length - 1, sum, dif;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];

                if (sum == target) return target;
                else if (sum > target) {
                    end--;
                    dif = sum - target;
                } else {
                    dif = target - sum;
                    start++;
                }
                if (dif < closestSumDif) {
                    closestSumDif = dif;
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}

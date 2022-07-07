package com.test.leetcode.page1.chapter10.t16;

/**
 * @ClassName: Solution20220629
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/29 10:50
 * @Version: 1.0
 */
public class Solution20220629 {

    public int threeSumClosest(int[] nums, int target) {
        int ant = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int l = i + 1; l < nums.length; l++) {
                for (int m = l + 1; m < nums.length; m++) {
                    int sum = nums[i] + nums[l] + nums[m];
                    if (sum == target) {
                        return target;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - ant)) {
                        ant = sum;
                    }
                }
            }
        }
        return ant;
    }
}

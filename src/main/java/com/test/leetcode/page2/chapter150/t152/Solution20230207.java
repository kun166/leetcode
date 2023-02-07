package com.test.leetcode.page2.chapter150.t152;

/**
 * @ClassName: Solution20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 10:21
 * @Version: 1.0
 */
public class Solution20230207 {

    public int maxProduct(int[] nums) {
        int ant = nums[0];
        int number = Integer.MIN_VALUE;
        // 从左向右
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                number = Integer.MIN_VALUE;
                ant = Math.max(ant, 0);
            } else {
                if (number == Integer.MIN_VALUE) {
                    number = nums[i];
                } else {
                    number *= nums[i];
                }
                ant = Math.max(ant, number);
            }
        }
        // 从右向左找
        number = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                number = Integer.MIN_VALUE;
                ant = Math.max(ant, 0);
            } else {
                if (number == Integer.MIN_VALUE) {
                    number = nums[i];
                } else {
                    number *= nums[i];
                }
                ant = Math.max(ant, number);
            }
        }
        return ant;
    }

}

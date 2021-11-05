package com.test.leetcode.page1.chapter30.t31;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-18 16:24
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i);
            System.out.print("->");
        }
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i1 = -1, i2 = 0;
        for (int i = length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && j > i1) {
                    // 记录坐标
                    i1 = j;
                    i2 = i;
                }
            }
        }
        if (i1 > -1) {
            // 交换i1和i2的位置
            int m = nums[i2];
            nums[i2] = nums[i1];
            nums[i1] = m;
            //对剩余的队列从小到大排序
            if (i1 + 1 < length - 1) {
                int[] rightA = new int[length - i1 - 1];
                System.arraycopy(nums, i1 + 1, rightA, 0, length - i1 - 1);
                Arrays.sort(rightA);
                System.arraycopy(rightA, 0, nums, i1 + 1, length - i1 - 1);
            }
            return;
        }

        int harf = length / 2;
        for (int i = 0; i < harf; i++) {
            int m = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = m;
        }
    }
}

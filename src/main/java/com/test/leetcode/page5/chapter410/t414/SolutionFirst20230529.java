package com.test.leetcode.page5.chapter410.t414;

import java.util.Arrays;

/**
 * @ClassName: Solution20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 10:26
 * @Version: 1.0
 */
public class SolutionFirst20230529 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了87.36%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了23.54%的用户
     * 通过测试用例：34 / 34
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        long[] array = new long[3];
        Arrays.fill(array, Long.MIN_VALUE);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 处理第一个
            if (array[0] == Long.MIN_VALUE || array[0] == nums[i]) {
                array[0] = nums[i];
                continue;
            }
            if (array[0] < nums[i]) {
                swap(array, 0, nums, i);
            }

            // 处理第二个
            if (array[1] == Long.MIN_VALUE || array[1] == nums[i]) {
                array[1] = nums[i];
                continue;
            }
            if (array[1] < nums[i]) {
                swap(array, 1, nums, i);
            }

            // 处理第三个
            if (array[2] == Long.MIN_VALUE || array[2] < nums[i]) {
                array[2] = nums[i];
            }
        }
        return (int) (array[2] == Long.MIN_VALUE ? array[0] : array[2]);

    }

    public void swap(long[] array, int i1, int[] nums, int i2) {
        long mid = array[i1];
        array[i1] = nums[i2];
        nums[i2] = (int) mid;
    }
}

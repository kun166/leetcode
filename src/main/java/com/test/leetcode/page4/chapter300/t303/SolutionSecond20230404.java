package com.test.leetcode.page4.chapter300.t303;

/**
 * @ClassName: Solution20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 17:45
 * @Version: 1.0
 */
public class SolutionSecond20230404 {

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：44.5 MB, 在所有 Java 提交中击败了20.88%的用户通过测试用例：15 / 15
     */
    class NumArray {
        int[] array;

        public NumArray(int[] nums) {
            array = new int[nums.length];
            array[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                array[i] = array[i - 1] + nums[i];
            }

        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return array[right];
            } else {
                return array[right] - array[left - 1];
            }
        }
    }
}

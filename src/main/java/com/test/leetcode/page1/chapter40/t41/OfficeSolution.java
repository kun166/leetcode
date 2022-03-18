package com.test.leetcode.page1.chapter40.t41;

/**
 * @ClassName: OfficeSolution
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/16 10:34
 * @Version: 1.0
 */
public class OfficeSolution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 先将负数，转化成一个大于nums数组长度的值。遍历完后就没有负数了
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 把小于nums数组长度的值的位置的那个数置为负数
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 第一个正数的下标，即为需要查找的数
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

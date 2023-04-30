package com.test.leetcode.page4.chapter330.t334;

/**
 * @ClassName: Solution20230426
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/26 16:44
 * @Version: 1.0
 */
public class Solution20230426 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了44.23%的用户
     * 内存消耗：91.2 MB, 在所有 Java 提交中击败了38.72%的用户
     * 通过测试用例：78 / 78
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int first = 0, second = -1, third = -1;
        for (int i = 1; i < nums.length; i++) {
            if (second != -1 && nums[i] > nums[second]) {
                // 满足三联，返回true
                return true;
            }
            //说明 second == -1 或者nums[i] <= nums[second]
            if (nums[i] > nums[first]) {
                second = i;
                continue;
            }
            // nums[i] <= nums[first]
            if (nums[i] < nums[first]) {
                if (third == -1) {
                    third = i;
                }
            }
            if (third == -1) {
                continue;
            }
            if (nums[i] < nums[third]) {
                third = i;
            }
            if (nums[i] > nums[third]) {
                first = third;
                second = i;
                third = -1;
            }
        }
        return false;
    }
}

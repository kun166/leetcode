package com.test.leetcode.page4.chapter330.t334;

/**
 * @ClassName: OfficialFirst20230427
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/27 08:48
 * @Version: 1.0
 */
public class OfficialFirst20230427 {

    /**
     * leftMin[i]表示截止到下标i为止的，i及i左侧下标最小的数
     * rightMax[i]标识，从下标i开始到数组结束，右侧最大的那个数
     * <p>
     * 这思路不错，我都没想到……
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

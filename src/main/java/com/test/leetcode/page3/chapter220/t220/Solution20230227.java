package com.test.leetcode.page3.chapter220.t220;

/**
 * @ClassName: Solution20230227
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/27 21:07
 * @Version: 1.0
 */
public class Solution20230227 {

    /**
     * 滑动窗口？
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + indexDiff && j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.test.leetcode.page3.chapter220.t220;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 09:36
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 感觉要超时……
     * <p>
     * 超出时间限制
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= indexDiff; j++) {
                if (i - j < 0)
                    break;
                if (Math.abs(nums[i] - nums[i - j]) <= valueDiff)
                    return true;
            }
        }
        return false;
    }
}

package com.test.leetcode.page3.chapter210.t219;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 09:11
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 这个题没法排序,只能用map?
     *
     * 21ms	击败27.85%
     * 58.48MB	击败5.00%
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

package com.test.leetcode.page1.chapter0.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20250207
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/7 14:28
 * @Version: 1.0
 */
public class Solution20250207 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

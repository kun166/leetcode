package com.test.leetcode.page1.chapter0.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20220621
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/21 09:16
 * @Version: 1.0
 */
public class Solution20220621 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

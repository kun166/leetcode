package com.test.leetcode.page1.chapter0.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之合
 *
 * @ClassName: Solution
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/11/27 17:33
 * @Version: 1.0
 */
public class Solution {

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

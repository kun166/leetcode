package com.test.leetcode.review;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-30 11:11
 */
public class Solution1 {

    @Test
    public void test() {
        int[] nums = twoSum1(new int[]{19290,20000}, 39290);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum1(int[] nums, int target) {
        int volume = 2 << 10; //2048
        int bitNum = volume - 1; //11111111111
        int[] res = new int[volume];
        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitNum;
            if (res[c] != 0) {
                return new int[]{res[c] - 1, i};
            }
            res[nums[i] & bitNum] = i + 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

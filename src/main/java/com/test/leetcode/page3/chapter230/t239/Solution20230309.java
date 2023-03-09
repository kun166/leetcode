package com.test.leetcode.page3.chapter230.t239;

import java.util.TreeMap;

/**
 * @ClassName: Solution20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 16:59
 * @Version: 1.0
 */
public class Solution20230309 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = treeMap.lastKey();
        for (int i = 1; i < ans.length; i++) {
            if (nums[i + k - 1] == nums[i - 1]) {
                ans[i] = ans[i - 1];
            } else {
                int count = treeMap.get(nums[i - 1]);
                if (count == 1) {
                    treeMap.remove(nums[i - 1]);
                } else {
                    treeMap.put(nums[i - 1], count - 1);
                }
                treeMap.put(nums[i + k - 1], treeMap.getOrDefault(nums[i + k - 1], 0) + 1);
                ans[i] = treeMap.lastKey();
            }
        }
        return ans;
    }
}

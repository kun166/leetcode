package com.test.leetcode.page3.chapter210.t219;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230227
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/27 20:51
 * @Version: 1.0
 */
public class Solution20230227 {

    /**
     * 这题也简单啊
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            // 如果不存在则设置，如果存在则更新nums[i]新的位置
            map.put(nums[i], i);
        }
        return false;
    }
}

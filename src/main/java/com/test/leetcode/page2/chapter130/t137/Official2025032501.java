package com.test.leetcode.page2.chapter130.t137;

import java.util.*;

/**
 * @ClassName: Official2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 10:49
 * @Version: 1.0
 */
public class Official2025032501 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}

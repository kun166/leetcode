package com.test.leetcode.page6.chapter520.t523;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230809
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/9 15:46
 * @Version: 1.0
 */
public class Official20230809 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}

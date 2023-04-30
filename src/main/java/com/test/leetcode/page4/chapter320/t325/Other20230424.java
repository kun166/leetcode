package com.test.leetcode.page4.chapter320.t325;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Other20230424
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/24 09:41
 * @Version: 1.0
 */
public class Other20230424 {

    /**
     * 前缀和加hash
     * 这个遍历一遍就行，真是牛逼
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Integer, Integer> preSumIndex = new HashMap<>();
        int ans = 0;
        // 前缀和
        int preSum = 0;
        // 0 出现的位置在 -1 位置处
        preSumIndex.put(0, -1);
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];
            // 确保记录的是第一次出现的位置
            if (!preSumIndex.containsKey(preSum)) {
                preSumIndex.put(preSum, i);
            }
            // 检查一下是否需要更新答案
            if (preSumIndex.containsKey(preSum - k)) {
                ans = Math.max(ans, i - preSumIndex.get(preSum - k));
            }
        }
        return ans;
    }
}

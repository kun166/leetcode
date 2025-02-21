package com.test.leetcode.page5.chapter490.t494;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: OtherThird20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 09:46
 * @Version: 1.0
 */
public class OtherThird20230705 {

    Map<String, Integer> cache = new HashMap<>();

    /**
     * 记忆化搜索
     * <p>
     * 执行用时：108 ms, 在所有 Java 提交中击败了30.21%的用户
     * 内存消耗：43.8 MB, 在所有 Java 提交中击败了5.07%的用户
     * 通过测试用例：140 / 140
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }

    int dfs(int[] nums, int t, int u, int cur) {
        String key = u + "_" + cur;
        if (cache.containsKey(key)) return cache.get(key);
        if (u == nums.length) {
            cache.put(key, cur == t ? 1 : 0);
            return cache.get(key);
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        cache.put(key, left + right);
        return cache.get(key);
    }

}

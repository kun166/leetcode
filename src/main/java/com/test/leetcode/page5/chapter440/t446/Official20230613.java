package com.test.leetcode.page5.chapter440.t446;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230613
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/13 08:41
 * @Version: 1.0
 */
public class Official20230613 {

    public int numberOfArithmeticSlices(int[] nums) {
        // 返回
        int ans = 0;
        // 数组长度
        int n = nums.length;
        //f[i][d]表示尾项为nums[i]，公差为d的弱等差子序列的个数
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            // 初始化f数组
            // 以nums[i]结尾的公差有好多，用HashMap记录
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // 计算公差
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                // 注意这地方，是先进行了ans+=cnt,然后后面又执行了f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
                ans += cnt;
                // 也就是说，哪怕两个数构成了一个弱等差，存在了f[i]了，但是没有加到ans里，只有等下一个等差来了才算到cnt里
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}

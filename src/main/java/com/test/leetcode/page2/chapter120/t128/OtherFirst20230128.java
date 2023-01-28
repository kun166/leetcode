package com.test.leetcode.page2.chapter120.t128;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: OtherFirst20230128
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 15:12
 * @Version: 1.0
 */
public class OtherFirst20230128 {

    public int longestConsecutive(int[] nums) {
        // 建立一个存储所有数的哈希表，同时起到去重功能
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // 遍历去重后的所有数字
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }

}

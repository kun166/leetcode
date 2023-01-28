package com.test.leetcode.page2.chapter120.t128;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: OtherSecond20230128
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 15:26
 * @Version: 1.0
 */
public class OtherSecond20230128 {

    /**
     * 哈希表记录右边界
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // key表示num，value表示num最远到达的连续右边界
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化每个num的右边界为自己
        for (int num : nums) {
            map.put(num, num);
        }

        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int right = map.get(num);
                // 遍历得到最远的右边界
                while (map.containsKey(right + 1)) {
                    right = map.get(right + 1);
                }
                // 更新右边界
                map.put(num, right);
                // 更新答案
                ans = Math.max(ans, right - num + 1);
            }

        }
        return ans;
    }
}

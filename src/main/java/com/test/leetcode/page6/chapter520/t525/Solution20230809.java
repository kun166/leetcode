package com.test.leetcode.page6.chapter520.t525;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230809
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/9 16:54
 * @Version: 1.0
 */
public class Solution20230809 {

    /**
     * 执行用时：29 ms, 在所有 Java 提交中击败了11.39%的用户
     * 内存消耗：53.1 MB, 在所有 Java 提交中击败了35.60%的用户
     * 通过测试用例：564 / 564
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int max = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (sum == 0) {
                max = i + 1;
                continue;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }
        }
        return max;
    }
}

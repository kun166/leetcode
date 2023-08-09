package com.test.leetcode.page6.chapter520.t525;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230809
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/9 17:21
 * @Version: 1.0
 */
public class Official20230809 {

    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了47.38%的用户
     * 内存消耗：53.2 MB, 在所有 Java 提交中击败了25.00%的用户
     * 通过测试用例：564 / 564
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

}

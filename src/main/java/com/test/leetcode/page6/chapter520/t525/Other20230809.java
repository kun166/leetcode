package com.test.leetcode.page6.chapter520.t525;

/**
 * @ClassName: Other20230809
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/9 17:30
 * @Version: 1.0
 */
public class Other20230809 {

    /**
     * 3秒……这……
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int[] map = new int[(n << 1) + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = n;
        }
        map[n] = -1;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int index = (sum << 1) + n - i - 1;
            if (map[index] != n) {
                maxLen = Math.max(maxLen, i - map[index]);
            } else {
                map[index] = i;
            }
        }
        return maxLen;
    }
}

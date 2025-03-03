package com.test.leetcode.page1.chapter40.t42;

/**
 * @ClassName: Solution20250224
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/24 09:26
 * @Version: 1.0
 */
public class Solution2025022401 {

    public int trap(int[] height) {
        int length = height.length;
        int[] water = new int[length];
        int maxHeightIndex = 0, ans = 0;
        for (int i = 1; i < length; i++) {
            // 从左向右
            if (height[i] >= height[maxHeightIndex]) {
                maxHeightIndex = i;
            } else {
                water[i] = height[maxHeightIndex] - height[i];
            }
        }

        maxHeightIndex = length - 1;
        for (int i = maxHeightIndex; i >= 0; i--) {
            // 从右向左
            if (height[i] >= height[maxHeightIndex]) {
                maxHeightIndex = i;
            } else {
                ans += Math.min(height[maxHeightIndex] - height[i], water[i]);
            }
        }
        return ans;
    }
}

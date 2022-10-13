package com.test.leetcode.page1.chapter40.t42;

/**
 * @ClassName: OfficeFirst20221011
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/11 16:15
 * @Version: 1.0
 */
public class OfficeFirst20221011 {

    /**
     * 这个算法是基于动态规划
     * 总体的思路如下：
     * 1，遍历柱子数组，只记录当前柱子能存多少水，然后累加即为结果。
     * 2，如何计算当前柱子能存多少水？当前柱子左边最高的柱子，右边最高的柱子，取值小的那个，然后和当前柱子高度比较，就能算出来存多少水。
     * <p>
     * 本算法是上述思路的一个变种，即左边的最高柱子，及右边的最高柱子，都包含当前柱子本身，使代码量简化不少
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        // 记录当前坐标左边最高的柱子高度(包含当前坐标)
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 当前坐标右边最高的柱子高度(包含当前坐标)
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            // 只计算当前坐标能储存的水，然后累加
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}

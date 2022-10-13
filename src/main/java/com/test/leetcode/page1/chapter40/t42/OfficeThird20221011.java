package com.test.leetcode.page1.chapter40.t42;

/**
 * @ClassName: OfficeThird20221011
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/11 19:26
 * @Version: 1.0
 */
public class OfficeThird20221011 {

    /**
     * 双指针解法
     * 这个解法有点逆天啊
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                /**
                 * 由动态规划得出：当前节点的存水量:左侧最高点和右侧最高点的小值减去当前节点的值，这个是无异议的了
                 * 这里面还有隐藏条件啊：如果height[left] < height[right]，则必有leftMax <= rightMax
                 * 推导如下：
                 * 如果height[left] < height[right],则肯定是移动了left，也就是在此之前必有leftMax[left-1]<=rightMax[right]
                 * 此时还存在height[left] < height[right]，则必定会有leftMax <= rightMax
                 *
                 */
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}

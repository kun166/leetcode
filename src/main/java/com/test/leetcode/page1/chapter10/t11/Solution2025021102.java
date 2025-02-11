package com.test.leetcode.page1.chapter10.t11;

/**
 * @ClassName: Solution2025021102
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 10:31
 * @Version: 1.0
 */
public class Solution2025021102 {

    /**
     * 唉唉唉，看了答案咱也来温习一下吧……
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            /**
             * 这道题的精髓就是左右平等,
             * 每一个循环不是从左往右找，就是从右往左左找，且减少的距离都是1
             * 那就只能去掉较小值的那个……
             */
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return ans;
    }
}

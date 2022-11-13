package com.test.leetcode.page1.chapter50.t55;

/**
 * @ClassName: Official20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 16:00
 * @Version: 1.0
 */
public class Official20221113 {

    /**
     * 这个题看似是寻找值为0的点，能不能过的去，实则是看最大长度和当前坐标的比较，秒啊
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.test.leetcode.page1.chapter70.t75;

/**
 * @ClassName: Official20221129Second
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/29 11:54
 * @Version: 1.0
 */
public class Official20221129Second {

    /**
     * 双指针。这个只管排好0和1,2就不用管了……
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        // p0是指向0的下一个位置，p1是指向1的下一个位置？
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                // 如果是1，则换到p1处
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                // 如果是0，则换到p0处
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    // p0<p1,说明有1，且现在的nums[i]==1
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}

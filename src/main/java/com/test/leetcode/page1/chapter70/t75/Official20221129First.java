package com.test.leetcode.page1.chapter70.t75;

/**
 * @ClassName: Official20221129First
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/29 11:44
 * @Version: 1.0
 */
public class Official20221129First {

    /**
     * 单指针
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        // ptr指向的是下一个0需要交换到的位置
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        // 0都已经排好序了，然后剩下的就是排1
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}

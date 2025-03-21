package com.test.leetcode.page2.chapter150.t154;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 17:08
 * @Version: 1.0
 */
public class Solution2025032101 {

    /**
     * 呃,尝试一下吧
     * 呃,牛逼了,一次过了……
     * <p>
     * 0ms	击败100.00%
     * 42.31MB	击败37.47%
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int pl, int pr) {
        while (pl < pr && nums[pl] == nums[pl + 1]) {
            pl++;
        }
        while (pl < pr && nums[pr] == nums[pr - 1]) {
            pr--;
        }
        if (pl < pr && nums[pl] == nums[pr]) {
            pl++;
        }
        if (nums[pl] <= nums[pr]) {
            // 说明已经排好序了
            return nums[pl];
        }
        int mid = pl + ((pr - pl) >> 1);
        if (nums[pl] <= nums[mid]) {
            // pl到mid已经排好序了
            if (nums[pl] < nums[pr]) {
                return nums[pl];
            }
            return findMin(nums, mid + 1, pr);
        } else {
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }
            return findMin(nums, pl, mid);
        }
    }
}

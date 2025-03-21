package com.test.leetcode.page2.chapter150.t153;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 15:18
 * @Version: 1.0
 */
public class Solution2025032102 {

    /**
     * <p>
     * 0ms	击败100.00%
     * 41.23MB	击败47.79%
     * <p>
     * 这内存真假……比{@link Solution2025032101}还高
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int pl, int pr) {
        if (pl == pr)
            return nums[pl];
        // 二分
        int mid = pl + ((pr - pl) >> 1);
        if (nums[pl] < nums[mid]) {
            /**
             * 1,pl到mid是排好序的,pl到mid的最小值是nums[pl]
             * 2,mid+1到pr,有可能是排好序的,有可能是未排好序的,取nums[pr]
             */
            if (nums[pl] < nums[pr]) {
                // 这种情况,感觉就是都已经排好序了……,应该可以直接返回nums[pl]
                return nums[pl];
            } else {
                return findMin(nums, mid + 1, pr);
            }
        } else {
            // mid+1到pr是排好序的
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            } else {
                return findMin(nums, pl, mid);
            }
        }
    }
}

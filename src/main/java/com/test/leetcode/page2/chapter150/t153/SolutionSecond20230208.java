package com.test.leetcode.page2.chapter150.t153;

/**
 * @ClassName: SolutionSecond20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 08:44
 * @Version: 1.0
 */
public class SolutionSecond20230208 {


    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    /**
     * 这个解法的精髓如下：
     * 最小值一定存在如下两个地方：
     * 1,如果从start到mid,mid+1到end，都已经排好序了，那最小值肯定是nums[mid+1]
     * 2,最小值存在在那个未排好序的数组段里，要么在start到mid，要么在mid+1到end里
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int findMin(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        if (nums[start] <= nums[mid]) {
            //前段排好序了
            if (nums[mid + 1] <= nums[end]) {
                // 后段也排好序了，则最小值一定是nums[mid+1]
                return nums[mid + 1];
            }
            return findMin(nums, mid + 1, end);
        }
        return findMin(nums, start, mid);
    }

}

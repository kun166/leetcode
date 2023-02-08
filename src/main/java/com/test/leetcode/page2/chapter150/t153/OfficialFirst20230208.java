package com.test.leetcode.page2.chapter150.t153;

/**
 * @ClassName: OfficialFirst20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 08:58
 * @Version: 1.0
 */
public class OfficialFirst20230208 {

    /**
     * 这个官方解答，更巧妙。
     * 如果吃不透这个题，这个解法是不太好理解，需要关注的点有些多
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                // 说明从pivot到high已经排好序了。最小值要么是nums[pivot]要么在low到pivot-1里面
                high = pivot;
            } else {
                // pivot到high未排好序，则最小值一定在未排好序的这段里,即pivot到high里，
                // 更精准的说，是在pivot+1到high里
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}

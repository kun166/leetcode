package com.test.leetcode.page1.chapter80.t81;

/**
 * @ClassName: Solution2025030502
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 10:43
 * @Version: 1.0
 */
public class Solution2025030502 {

    public boolean search(int[] nums, int target) {
        int pl = 0, pr = nums.length - 1;
        if (nums[pl] == nums[pr]) {
            if (nums[pl] == target)
                return true;
            int number = nums[pl];
            while (pl < pr && nums[pl] == number)
                pl++;
            while (pl < pr && nums[pr] == number)
                pr--;
        }
        return search(nums, target, pl, pr);
    }

    public boolean search(int[] nums, int target, int pl, int pr) {
        if (pl >= pr) {
            return nums[pr] == target;
        }
        int mid = pl + ((pr - pl) >> 1);
        if (nums[mid] == target)
            return true;
        if (nums[pl] < nums[mid]) {
            // pl到mid是排好序的
            if (nums[pl] <= target && nums[mid] > target)
                return search(nums, target, pl, mid - 1);
            else
                return search(nums, target, mid + 1, pr);
        } else {
            // mid到pr是排好序的
            if (nums[mid] < target && nums[pr] >= target)
                return search(nums, target, mid + 1, pr);
            else
                return search(nums, target, pl, mid - 1);
        }
    }
}

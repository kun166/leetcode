package com.test.leetcode.page1.chapter30.t33;

/**
 * @ClassName: OfficeSolution
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/22 17:04
 * @Version: 1.0
 */
public class OfficeSolution {

    /**
     * 解法清奇
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 双指针
        int l = 0, r = n - 1;
        while (l <= r) {
            // 取中位数
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                // 如果中位数命中，则返回
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // 说明已经排好序。注意这个=号一定要加上啊
                if (nums[0] <= target && target < nums[mid]) {
                    // 继续注意这等号。说明target在已经排好序的0到mid里面
                    r = mid - 1;
                } else {
                    // 说明在mid+1到r里面
                    l = mid + 1;
                }
            } else {
                // 说明mid到r时排好序的
                if (nums[mid] < target && target <= nums[n - 1]) {
                    // 说明在这个排好序的里面
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

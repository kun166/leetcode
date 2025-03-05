package com.test.leetcode.page1.chapter80.t81;

import org.junit.Test;

/**
 * @ClassName: Solution2025030501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 10:02
 * @Version: 1.0
 */
public class Solution2025030501 {

    /**
     * nums = [1,0,1,1,1]
     * target = 0
     */
    @Test
    public void test() {
        System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    /**
     * 这题不比找出旋转节点,直接折半查找法就行。和33题解法没啥分别？
     * <p>
     * 这种解法是完全错误的……和33题还是有区别的……
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public boolean search(int[] nums, int target, int pl, int pr) {
        /**
         * 退出条件
         * 这个地方的退出条件为什么这么写?
         * 1,要保证二分之后,两边的数组长度都要大于等于2个,不然判断升序就是错误的。
         * 比如[1,0]查找0,二分之后是查找不到0的。所以要保证二分之前的数字长度要不小于4个
         * 2,数组长度为pr-pl+1
         */
        if (pr - pl <= 3) {
            for (int i = pl; i <= pr; i++) {
                if (nums[i] == target)
                    return true;
            }
            return false;
        }
        int mid = pl + ((pr - pl) >> 1);
        if (nums[mid] == target)
            return true;
        if (nums[pl] <= nums[mid]) {
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

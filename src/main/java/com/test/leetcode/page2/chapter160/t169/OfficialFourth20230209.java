package com.test.leetcode.page2.chapter160.t169;

/**
 * @ClassName: OfficialFourth20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 16:28
 * @Version: 1.0
 */
public class OfficialFourth20230209 {

    /**
     * 分治
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        // 数组中仅有一个元素，返回这个元素
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        // 折半
        int mid = (hi - lo) / 2 + lo;

        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        // 如果两个元素值相等，返回这个元素
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        // 返回出现次数最大的那个数
        return leftCount > rightCount ? left : right;
    }

    /**
     * 寻找数组中起始位置到结束位置的这段内，num出现的次数
     *
     * @param nums 数组
     * @param num  寻找的数
     * @param lo   起始位置
     * @param hi   结束位置
     * @return
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

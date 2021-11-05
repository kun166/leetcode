package com.test.leetcode.page1.chapter20.t27;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 16:31
 */
public class Solution {

    @Test
    public void test() {
        //int[] array = {3, 2, 2, 3};
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        //int[] array = new int[]{2, 2, 2, 2, 2, 2, 4, 2};
        System.out.println(removeElement(array, 2));
        for (int i : array) {
            System.out.print(i);
            System.out.print("->");
        }


    }

    /**
     * 其实这个解法已经错了，原题要求不改变原数组顺序，这个已经改变了
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] == val) {
                while (end > start && nums[end] == val) {
                    end--;
                }
                if (start == end) {
                    return end;
                }
                nums[start] = nums[end];
                end--;
            }
            start++;
        }
        return end + 1;
    }
}

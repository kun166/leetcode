package com.test.leetcode.page3.chapter280.t287;

import org.junit.Test;

/**
 * @ClassName: SolutionSecond20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 17:37
 * @Version: 1.0
 */
public class SolutionSecond20230331 {

    @Test
    public void test() {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    /**
     * 想起来异或,可以用一下
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = number;
            number ^= nums[i];
            if (number == pre) {
                return nums[i];
            }
        }
        return -1;
    }
}

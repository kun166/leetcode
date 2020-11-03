package com.test.leetcode.chapter10.t15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-20 10:18
 */
public class Solution20201020 {

    @Test
    public void test() {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> l : list) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = length - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }

                if (nums[i] + nums[start] + nums[end] == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[start], nums[end]}));
                    start++;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}

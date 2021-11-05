package com.test.leetcode.page1.chapter10.t18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 10:10
 */
public class Solution20201023 {

    @Test
    public void test() {
        List<List<Integer>> list = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> l : list) {
            System.out.println();
            for (int i : l) {
                System.out.print(i + ",");
            }
        }
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 先排序，不排序就无法去重
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int start = j + 1, end = length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        // 寻找下一个不重复的值
                        int startV = nums[start];
                        while (start < end && nums[start] == startV) {
                            start++;
                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

        }
        return list;
    }
}

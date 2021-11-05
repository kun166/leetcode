package com.test.leetcode.page1.chapter40.t47;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-29 11:00
 */
public class Solution20201029 {

    @Test
    public void test() {
        List<List<Integer>> result = permuteUnique(new int[]{1, 1});
        for (List<Integer> l : result) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        // 只要涉及到去重，必须重排
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        permuteUnique(result, list, nums, 0);
        return result;
    }

    public void permuteUnique(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        int length = list.size();
        for (int i = 0; i <= length; i++) {
            // 允许前插，不允许后插
            // 去除重复字符插入前面位置和后面位置一样的情况。
            if (i != 0 && nums[index] == list.get(i - 1)) {
                continue;
            }

//            if (isMatch(list) && i == 0 || i == length) {
//                continue;
//            }

            list.add(i, nums[index]);
            // 去除对称的情况。
            if (i == length && isMatch(list)) {
                list.remove(i);
                continue;
            }

            permuteUnique(result, list, nums, index + 1);
            list.remove(i);
        }
    }

    public boolean isMatch(List<Integer> list) {
        int length = list.size();
        if (length <= 1) {
            return false;
        }
        int start = 0, end = list.size() - 1;
        while (start < end && list.get(start) == list.get(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}

package com.test.leetcode.chapter70.t78;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-12 17:35
 */
public class Solution {

    @Test
    public void test() {
        List<List<Integer>> ans = subsets(new int[]{1, 2, 3});
        System.out.println(JSON.toJSONString(ans));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i <= nums.length; i++) {
//            subsets(ans, list, nums, i, 0);
//        }
        subsets(ans, list, nums, 0);
        return ans;
    }

    public void subsets(List<List<Integer>> ans, LinkedList<Integer> list, int[] nums, int length, int index) {
        if (list.size() == length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (nums.length - index < length - list.size())
            return;

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(ans, list, nums, length, i + 1);
            list.removeLast();
        }

    }

    public void subsets(List<List<Integer>> ans, LinkedList<Integer> list, int[] nums, int index) {
        ans.add(new ArrayList<>(list));
        
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(ans, list, nums, i + 1);
            list.removeLast();
        }

    }
}

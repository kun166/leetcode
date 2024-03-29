package com.test.leetcode.page2.chapter120.t128;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-16 10:00
 */
public class SolutionOffice {


    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // 放到hash表里
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        // 设置最大连续长度为0
        int longestStreak = 0;

        for (int num : num_set) {
            // 遍历每一个数
            if (!num_set.contains(num - 1)) {
                // 如果该数的上一个数不存在。那就是不连续了。
                int currentNum = num;
                int currentStreak = 1;

                // 寻找从该数开始的连续最长数列是多少
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
            // else不管，这个解法思路很好很牛
        }
        return longestStreak;
    }
}


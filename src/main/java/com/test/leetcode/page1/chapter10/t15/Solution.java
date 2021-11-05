package com.test.leetcode.page1.chapter10.t15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 16:38
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, 3, -1, -4, -5};
        List<int[]> list = find(nums);
        for (int[] a : list) {
            System.out.println();
            for (int i : a) {
                System.out.print(i + " ");
            }
        }

    }

    /**
     * 看了官网的解题思路，自己再实现一遍
     *
     * @param array
     * @return
     */
    public List<int[]> find(int[] array) {
        int length = array.length;
        // 找不重复的三个数，必须排序，不排序，很难去重!
        Arrays.sort(array);
        List<int[]> ans = new ArrayList<>();

        // 第三个数的下标从最右侧开始

        for (int first = 0; first < length; first++) {
            // 第一层循环。把重复的数据去掉
            if (first > 0 && array[first] == array[first - 1]) continue;
            // 要寻找的那个数
            int target = 0 - array[first];
            int third = length - 1;

            for (int second = first + 1; second < length; second++) {
                // 第二层循环，从第一层循环的下一个位标开始寻找
                // 去重
                if (second > first + 1 && array[second] == array[second - 1]) continue;
                //再来个循环
                while (second < third && array[second] + array[third] > target) {
                    // 双下标找寻
                    third--;
                }
                if (second >= third) {
                    //退出循环了。说明，这个时候
                    break;
                }

                if (array[second] + array[third] == target) {
                    int[] a = {array[first], array[second], array[third]};
                    ans.add(a);
                }

            }
        }
        return ans;

    }
}

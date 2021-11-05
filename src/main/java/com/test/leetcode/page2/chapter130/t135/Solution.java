package com.test.leetcode.page2.chapter130.t135;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-21 11:17
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(candy(new int[]{29, 51, 87, 87, 72, 12}));
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        // 保存每个位置应该发多少颗糖
        int[] array = new int[ratings.length];
        // 初始化一颗糖的位置。该位置评分不高于左右两边评分
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0 || i == ratings.length - 1) {
                if (i == 0 && ratings[i] <= ratings[i + 1]) {
                    array[i] = 1;
                    // 向右
                    candy(ratings, array, i + 1, true);
                } else if (i == ratings.length - 1 && ratings[i] <= ratings[i - 1]) {
                    array[i] = 1;
                    candy(ratings, array, i - 1, false);
                }
            } else {
                if (ratings[i] <= ratings[i + 1] && ratings[i] <= ratings[i - 1]) {
                    array[i] = 1;
                    candy(ratings, array, i + 1, true);
                    candy(ratings, array, i - 1, false);
                }
            }
        }
        int result = 0;
        System.out.println(JSON.toJSONString(array));
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }

        return result;
    }

    public void candy(int[] ratings, int[] array, int index, boolean forward) {
        while (index >= 0 && index < ratings.length) {
            if (forward) {
                // 向右
                if (ratings[index] > ratings[index - 1]) {
                    array[index] = array[index - 1] + 1;
                    index++;
                } else {
                    break;
                }
            } else {
                // 向左
                if (ratings[index] > ratings[index + 1]) {
                    array[index] = array[index + 1] + 1;
                    index--;
                } else {
                    if (array[index + 1] != 1 && ratings[index] < ratings[index + 1]) {
                        array[index + 1] = Math.max(array[index] + 1, array[index + 1]);
                    }
                    break;
                }
            }
        }
    }
}

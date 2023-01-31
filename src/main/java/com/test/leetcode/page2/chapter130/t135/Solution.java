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

    /**
     * 这代码居然是我当年写出来的？现在写不出来了……
     * 这代码确实挺牛逼的，当年得想了多久才想出来啊
     */
    @Test
    public void test() {
        System.out.println(candy(new int[]{29, 51, 87, 87, 72, 12}));
    }

    /**
     * 找到发一颗糖果的孩子，然后分别向两边分发
     *
     * @param ratings
     * @return
     */
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
                // 第一个孩子和最后一个孩子需要单独处理
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

    /**
     * 计算坐标为index的孩子需要发的糖果数
     *
     * @param ratings 评分数组
     * @param array   糖果发放数量数组
     * @param index   孩子坐标
     * @param forward true，是从左向右计算,false是从右向左计算
     */
    public void candy(int[] ratings, int[] array, int index, boolean forward) {
        while (index >= 0 && index < ratings.length) {
            // 越界的不处理
            if (forward) {
                // 向右
                // 向右发糖只计算评分比当前孩子高的。即处于升序中的孩子。
                // 处于升序中的孩子，一定比左边的那个孩子多一块糖
                if (ratings[index] > ratings[index - 1]) {
                    // array[index] = Math.max(array[index],array[index - 1] + 1); 更好一些
                    array[index] = array[index - 1] + 1;
                    index++;
                } else {
                    // 一旦找到非升序的那个孩子，就可以跳出循环了
                    break;
                }
            } else {
                // 向左
                // 1,计算处于降序中的孩子。处于降序中的孩子，发糖果的数量一定比右边的孩子多一颗
                // 2,处于降序中波峰的孩子，这个孩子既处于升序，又处于降序，需要取两把最大的那个值
                if (ratings[index] > ratings[index + 1]) {
                    array[index] = array[index + 1] + 1;
                    index--;
                } else {
                    if (array[index + 1] != 1 && ratings[index] < ratings[index + 1]) {
                        array[index + 1] = Math.max(array[index] + 1, array[index + 1]);
                    }
                    // 一旦找到波峰，就可以退出循环了。
                    break;
                }
            }
        }
    }
}

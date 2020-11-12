package com.test.leetcode.chapter70.t75;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-11 16:25
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        // 定义白色和蓝色开始的坐标
        int white = -1, blue = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //红色
                if (white != -1) {
                    //和白色互换
                    nums[white] = 0;
                    nums[i] = 1;
                    white++;
                } else if (blue != -1) {
                    // 和蓝色互换
                    nums[blue] = 0;
                    nums[i] = 2;
                    blue++;
                } else
                    continue;
            }
            if (nums[i] == 1) {
                //白色
                if (blue != -1) {
                    // 和蓝色互换
                    nums[blue] = 1;
                    nums[i] = 2;
                    if (white == -1)
                        white = blue;
                    blue++;
                } else if (white == -1) {
                    white = i;
                }
                continue;
            }
            if (nums[i] == 2 && blue == -1)
                blue = i;
        }
    }
}

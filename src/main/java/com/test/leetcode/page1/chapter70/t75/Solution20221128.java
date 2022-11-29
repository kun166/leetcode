package com.test.leetcode.page1.chapter70.t75;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20221128
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/28 21:06
 * @Version: 1.0
 */
public class Solution20221128 {

    @Test
    public void test() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int whiteStart = -1, blueStart = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (whiteStart == -1) {
                    //和2换
                    if (blueStart != -1) {
                        nums[blueStart++] = 0;
                        nums[i] = 2;
                    }
                } else {
                    // 和1换
                    nums[whiteStart++] = 0;
                    nums[i] = 1;
                }
            }
            if (nums[i] == 1) {
                if (blueStart == -1) {
                    // 此时还没有2
                    whiteStart = whiteStart == -1 ? i : whiteStart;
                } else {
                    // 和2交换位置
                    whiteStart = whiteStart == -1 ? blueStart : whiteStart;
                    nums[blueStart++] = 1;
                    nums[i] = 2;
                }
            }
            if (nums[i] == 2 && blueStart == -1) {
                blueStart = i;
            }
        }
    }
}

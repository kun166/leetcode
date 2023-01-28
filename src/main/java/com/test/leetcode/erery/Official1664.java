package com.test.leetcode.erery;

/**
 * @ClassName: Official1664
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 09:41
 * @Version: 1.0
 */
public class Official1664 {


    public int waysToMakeFair(int[] nums) {
        // odd1当前的奇数之和，even1当前的偶数之和
        int odd1 = 0, even1 = 0;
        // odd2剩余的奇数之和，even2剩余的偶数之和
        int odd2 = 0, even2 = 0;
        // 先计算剩余的奇数之和，和剩余的偶数之和
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 += nums[i];
            } else {
                even2 += nums[i];
            }
        }
        int res = 0;
        // 第二次遍历
        for (int i = 0; i < nums.length; ++i) {
            // 先计算剩余的奇数之和，偶数之和
            if ((i & 1) != 0) {
                odd2 -= nums[i];
            } else {
                even2 -= nums[i];
            }
            // 判断
            if (odd1 + even2 == odd2 + even1) {
                ++res;
            }
            // 再计算当前的奇数之和，偶数之和
            if ((i & 1) != 0) {
                odd1 += nums[i];
            } else {
                even1 += nums[i];
            }
        }
        return res;
    }
}

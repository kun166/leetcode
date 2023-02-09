package com.test.leetcode.page2.chapter160.t169;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName: OfficialThird20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 16:19
 * @Version: 1.0
 */
public class OfficialThird20230209 {

    @Test
    public void test() {
    }

    /**
     * 随机化
     * 感觉这个也不靠谱吧？
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Random rand = new Random();
        // 最大出险次数
        int majorityCount = nums.length / 2;

        while (true) {
            // 随机出来的那个坐标的值
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    /**
     * 随机最大坐标到最小坐标中的某个值
     *
     * @param rand 随机数
     * @param min  最小坐标
     * @param max  最大坐标
     * @return
     */
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    /**
     * 判断给定的num值是否在nums中占了半数
     *
     * @param nums
     * @param num
     * @return
     */
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

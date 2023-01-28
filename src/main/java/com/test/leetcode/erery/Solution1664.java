package com.test.leetcode.erery;

import org.junit.Test;

/**
 * @ClassName: Solution1664
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/28 08:29
 * @Version: 1.0
 */
public class Solution1664 {

    @Test
    public void test() {
        System.out.println(waysToMakeFair(new int[]{1, 1, 1, 1, 1}));
    }

    public int waysToMakeFair(int[] nums) {
        // 建立两个数组，奇数和偶数
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        // 存放奇数
        int[] array1 = new int[length % 2 == 0 ? length / 2 : length / 2 + 1];
        array1[0] = nums[0];
        // 存放偶数
        int[] array2 = new int[length / 2];
        array2[0] = nums[1];

        boolean b = true;
        for (int i = 2; i < nums.length; i++) {
            if (b) {
                array1[i / 2] = array1[i / 2 - 1] + nums[i];
            } else {
                array2[i / 2] = array2[i / 2 - 1] + nums[i];
            }
            b = !b;
        }
        // 数量初始值为0
        int count = 0;
        //剔除第0个和最后一个元素，不影响奇偶顺序
        // 剔除第一个
        if (array1[array1.length - 1] - nums[0] == array2[array2.length - 1]) {
            count++;
        }
        // 剔除最后一个
        if (length % 2 == 0) {
            // 原数组长度是偶数，剔除的是偶数
            if (array1[array1.length - 1] == (array2[array2.length - 1] - nums[nums.length - 1])) {
                count++;
            }
        } else {
            // 原数组长度是奇数，剔除的是奇数
            if ((array1[array1.length - 1] - nums[nums.length - 1]) == array2[array2.length - 1]) {
                count++;
            }
        }
        // 剩余的数，剔除一个，之后的奇偶性就改变了
        for (int i = 1; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                // 剔除的是奇数
                // 奇数的和等于这个奇数之前的和加上这个奇数之后的偶数的和
                int sum1 = array1[i / 2 - 1] + array2[array2.length - 1] - array2[i / 2 - 1];
                // 偶数的和
                int sum2 = array2[i / 2 - 1] + array1[array1.length - 1] - array1[i / 2];
                if (sum1 == sum2) {
                    count++;
                }
            } else {
                // 剔除的是偶数,这个好像还得注意是不是第一个偶数
                int sum1, sum2;
                if (i == 1) {
                    sum1 = array1[0] + array2[array2.length - 1] - array2[0];
                    sum2 = array1[array1.length - 1] - array1[0];
                } else {
                    sum1 = array1[i / 2] + array2[array2.length - 1] - array2[i / 2];
                    sum2 = array2[i / 2 - 1] + array1[array1.length - 1] - array1[i / 2];
                }
                if (sum1 == sum2) {
                    count++;
                }
            }
        }
        return count;
    }

}

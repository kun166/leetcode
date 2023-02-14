package com.test.leetcode.page2.chapter170.t179;

import org.junit.Test;

/**
 * @ClassName: Solution20230214
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/14 10:17
 * @Version: 1.0
 */
public class Solution20230214 {

    @Test
    public void test() {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String largestNumber(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        int length = nums.length;
        while (length > 0) {
            int index = 0;
            for (int i = 1; i < length; i++) {
                if (compareTo(nums[i], nums[index]) > 0) {
                    index = i;
                }
            }
            buffer.append(nums[index]);
            // index和length-1互换位置
            nums[index] = nums[length - 1];
            length--;
        }
        return buffer.toString();
    }

    public int compareTo(int n1, int n2) {
        if (n1 == 0) {
            return -1;
        }
        if (n2 == 0) {
            return 1;
        }
        long number1 = n1;
        int number = n2;
        while (number > 0) {
            number1 *= 10;
            number /= 10;
        }
        number1 += n2;
        long number2 = n2;
        number = n1;
        while (number > 0) {
            number2 *= 10;
            number /= 10;
        }
        number2 += n1;
        return number1 > number2 ? 1 : -1;
    }


}

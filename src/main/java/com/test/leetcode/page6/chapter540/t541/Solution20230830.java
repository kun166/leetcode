package com.test.leetcode.page6.chapter540.t541;

/**
 * @ClassName: Solution20230830
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/30 16:33
 * @Version: 1.0
 */
public class Solution20230830 {

    /**
     * 0ms
     * 击败 100.00%使用 Java 的用户
     * 41.24MB
     * 击败 67.29%使用 Java 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }
        char[] array = s.toCharArray();
        int length = array.length;
        int start = 0;
        while (length >= 2 * k) {
            revers(array, start, start + k - 1);
            start = start + 2 * k;
            length -= 2 * k;
        }
        length = length >= k ? k : length;
        revers(array, start, start + length - 1);
        return new String(array);
    }

    public void revers(char[] array, int left, int right) {
        while (left < right) {
            char c = array[left];
            array[left] = array[right];
            array[right] = c;
            left++;
            right--;
        }
    }
}

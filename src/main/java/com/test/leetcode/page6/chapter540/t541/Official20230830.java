package com.test.leetcode.page6.chapter540.t541;

/**
 * @ClassName: Official20230830
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/30 16:52
 * @Version: 1.0
 */
public class Official20230830 {

    /**
     * 这写法牛啊
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}

package com.test.leetcode.page5.chapter480.t484;

/**
 * @ClassName: Official20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 14:53
 * @Version: 1.0
 */
public class Official20230703 {
    public int[] findPermutation(String s) {
        // 数组长度是字符串s的长度+1,计为n
        int[] res = new int[s.length() + 1];
        // 初始化res，从1到n
        for (int i = 0; i < res.length; i++)
            res[i] = i + 1;
        // 当前位置
        int i = 1;
        while (i <= s.length()) {
            // 记录第一个D或者I后第一个D的起始位置
            int j = i;
            // i-1是下标位置，i是位置，数组下标从0开始
            while (i <= s.length() && s.charAt(i - 1) == 'D')
                i++;
            // 连续的D翻转。注意这个是连续的D加后面的第一个I，进行翻转
            reverse(res, j - 1, i);
            i++;
        }
        return res;
    }

    /**
     * 对数组a进行从start到end的元素进行翻转
     *
     * @param a
     * @param start
     * @param end
     */
    public void reverse(int[] a, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            int temp = a[i + start];
            a[i + start] = a[end - i - 1];
            a[end - i - 1] = temp;
        }
    }
}

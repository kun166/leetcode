package com.test.leetcode.page4.chapter340.t345;

/**
 * @ClassName: Solution20230506
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/6 15:16
 * @Version: 1.0
 */
public class Solution20230506 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了96.48%的用户
     * 内存消耗：42.9 MB, 在所有 Java 提交中击败了7.55%的用户通
     * 过测试用例：480 / 480
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < right && !isVowel(array[left])) {
                left++;
            }
            while (left < right && !isVowel(array[right])) {
                right--;
            }
            if (left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return new String(array);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

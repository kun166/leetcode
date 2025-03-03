package com.test.leetcode.page1.chapter60.t66;

/**
 * @ClassName: Solution2025022701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 17:12
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 这题想不出来别的办法
     */
    public int[] plusOne(int[] digits) {
        // 遍历每一位是否都是9？
        int index = digits.length;
        while (--index >= 0 && digits[index] == 9) ;
        if (index == -1) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        int[] ans = new int[digits.length];
        /**
         * 呃，这道简单题都错了……
         * System.arraycopy(digits, 0, ans, 0, digits.length);
         */
        System.arraycopy(digits, 0, ans, 0, index + 1);
        ans[index]++;
        return ans;
    }
}

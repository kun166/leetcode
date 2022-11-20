package com.test.leetcode.page1.chapter60.t66;

/**
 * @ClassName: Solution20221119
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/19 17:10
 * @Version: 1.0
 */
public class Solution20221119 {

    public int[] plusOne(int[] digits) {
        int more = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && more == 1) {
                digits[i] = 0;
            } else {
                digits[i] += more;
                more = 0;
                break;
            }
        }
        if (more == 1) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
        return digits;
    }
}

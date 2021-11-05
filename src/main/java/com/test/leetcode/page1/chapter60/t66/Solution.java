package com.test.leetcode.page1.chapter60.t66;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 14:59
 */
public class Solution {

    @Test
    public void test() {
        int[] digits = new int[]{9};
        digits = plusOne(digits);
        System.out.println(JSON.toJSONString(digits));
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int pass = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i] = digits[i] + pass;
                pass = 0;
                break;
            }
        }
        if (pass == 1) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(ans, 1, digits, 0, digits.length);
            ans[0] = pass;
            return ans;
        }
        return digits;
    }
}

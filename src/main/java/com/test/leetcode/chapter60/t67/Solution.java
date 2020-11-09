package com.test.leetcode.chapter60.t67;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 15:16
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int aL = a.length();
        int bL = b.length();
        while (aL > 0 || bL > 0) {
            int aV = aL > 0 ? a.charAt(aL - 1) - '0' : 0;
            int bV = bL > 0 ? b.charAt(bL - 1) - '0' : 0;
            int sum = carry + aV + bV;
            if (sum > 1) {
                sum -= 2;
                carry = 1;
            } else
                carry = 0;
            aL--;
            bL--;
            ans.append((char) (sum + '0'));
        }
        if (carry == 1)
            ans.append('1');
        return ans.reverse().toString();
    }
}

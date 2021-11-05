package com.test.leetcode.page1.chapter10.t10;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 17:37
 */
public class Regular {

    @Test
    public void test() {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aaaaaa", "a*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }


    public boolean isMatch(String str, String reg) {
        char[] strA = str.toCharArray();
        char[] regA = reg.toCharArray();
        int strP = 0, regP = 0, strL = strA.length, regL = regA.length;
        while (strP < strL && regP < regL) {

            if (strA[strP] == regA[regP] || '.' == regA[regP]) {
                strP++;
                regP++;
            } else if ('*' == regA[regP]) {
                char c = strA[strP - 1];
                regP++;
                while (strP < strL && c == strA[strP]) {
                    strP++;
                }

            } else if (regP + 1 < regL && '*' == regA[regP + 1]) {
                // 诱探一下下一个字符是不是*
                regP += 2;
            } else {
                return false;
            }
        }
        if (strP == strL && regP == regL) {
            return true;
        }
        return false;
    }
}

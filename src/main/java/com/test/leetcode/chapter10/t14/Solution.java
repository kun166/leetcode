package com.test.leetcode.chapter10.t14;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 15:39
 */
public class Solution {

    @Test
    public void test() {
        String[] array = {"flower", "flow", "flight"};
        System.out.println(commonStr(array));
        array = new String[]{"dog", "racecar", "car"};
        System.out.println(commonStr(array));
    }

    public String commonStr(String[] array) {
        String cStr = array[0];
        int length = array.length;
        for (int i = 1; i < length; i++) {
            cStr = commonStr(cStr, array[i]);
            if (cStr.equals("")) {
                return cStr;
            }
        }
        return cStr;

    }

    public String commonStr(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i)) sb.append(s1.charAt(i));
            else return sb.toString();
        }
        return sb.toString();
    }
}

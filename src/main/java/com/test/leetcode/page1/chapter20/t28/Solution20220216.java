package com.test.leetcode.page1.chapter20.t28;

/**
 * @ClassName: Solution20220216
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/16 10:14
 * @Version: 1.0
 */
public class Solution20220216 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int stackLength = haystack.length(), needleLength = needle.length(), end;
        if ((end = (stackLength - needleLength)) < 0) {
            return -1;
        }
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needleLength - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

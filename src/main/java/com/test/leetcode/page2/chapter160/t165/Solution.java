package com.test.leetcode.page2.chapter160.t165;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-06 11:48
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] v1Array = version1.split("\\.");
        String[] v2Array = version2.split("\\.");
        int index1 = 0, index2 = 0;
        while (index1 < v1Array.length || index2 < v2Array.length) {
            if (index1 == v1Array.length) {
                if (Integer.parseInt(v2Array[index2++]) > 0) {
                    return -1;
                }
            } else if (index2 == v2Array.length) {
                if (Integer.parseInt(v1Array[index1++]) > 0) {
                    return 1;
                }
            } else {
                int i1 = Integer.parseInt(v1Array[index1++]);
                int i2 = Integer.parseInt(v2Array[index2++]);
                if (i1 > i2) {
                    return 1;
                } else if (i1 < i2) {
                    return -1;
                }
            }
        }
        return 0;
    }
}

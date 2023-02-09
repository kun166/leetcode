package com.test.leetcode.page2.chapter160.t165;

import org.junit.Test;

/**
 * @ClassName: Solution20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 17:17
 * @Version: 1.0
 */
public class Solution20230208 {

    @Test
    public void test() {
        System.out.println(compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int index = 0;
        while (index < a1.length || index < a2.length) {
            int n1 = index < a1.length ? Integer.parseInt(a1[index]) : 0;
            int n2 = index < a2.length ? Integer.parseInt(a2[index]) : 0;
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
            index++;
        }
        return 0;
    }
}

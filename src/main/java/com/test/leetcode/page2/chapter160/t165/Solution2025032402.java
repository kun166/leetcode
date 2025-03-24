package com.test.leetcode.page2.chapter160.t165;

import org.junit.Test;

/**
 * @ClassName: Solution2025032402
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 09:24
 * @Version: 1.0
 */
public class Solution2025032402 {

    @Test
    public void test() {
        System.out.println(compareVersion("1.2", "1.10"));
    }

    /**
     * 练练基本功吧
     * 0ms	击败100.00%
     * 40.74MB	击败58.39%
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int pl1 = 0, pr1 = 0, pl2 = 0, pr2 = 0;
        while (pr1 < version1.length() && pr2 < version2.length()) {
            while (pr1 < version1.length() && version1.charAt(pr1) != '.') {
                pr1++;
            }
            // 解析数字
            int i1 = parse(version1, pl1, pr1);
            /**
             * 这个地方忘了 pr1++;
             * 死循环了……
             */
            pr1++;
            pl1 = pr1;

            while (pr2 < version2.length() && version2.charAt(pr2) != '.') {
                pr2++;
            }

            int i2 = parse(version2, pl2, pr2);
            pr2++;
            pl2 = pr2;
            if (i1 != i2)
                return i1 > i2 ? 1 : -1;
        }

        while (pr1 < version1.length()) {
            while (pr1 < version1.length() && version1.charAt(pr1) != '.') {
                pr1++;
            }
            // 解析数字
            int i1 = parse(version1, pl1, pr1);
            if (i1 > 0)
                return 1;
            pr1++;
            pl1 = pr1;
        }

        while (pr2 < version2.length()) {
            while (pr2 < version2.length() && version2.charAt(pr2) != '.') {
                pr2++;
            }

            int i2 = parse(version2, pl2, pr2);
            if (i2 > 0)
                return -1;
            pr2++;
            pl2 = pr2;
        }
        return 0;
    }

    public int parse(String s, int pl, int pr) {
        int ans = 0;
        while (pl < pr) {
            ans = ans * 10 + (s.charAt(pl++) - '0');
        }
        return ans;
    }
}

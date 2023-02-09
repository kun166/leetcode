package com.test.leetcode.page2.chapter160.t165;

/**
 * @ClassName: OfficialSecond20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 17:58
 * @Version: 1.0
 */
public class OfficialSecond20230208 {

    /**
     * 双指针
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}

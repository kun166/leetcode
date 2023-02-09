package com.test.leetcode.page2.chapter160.t165;

/**
 * @ClassName: OfficialFirst20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 17:57
 * @Version: 1.0
 */
public class OfficialFirst20230208 {

    /**
     * 字符串分割
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }


}

package com.test.leetcode.page3.chapter270.t274;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230329
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/29 09:12
 * @Version: 1.0
 */
public class OfficialFirst20230329 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}

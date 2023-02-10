package com.test.leetcode.page2.chapter170.t170;

/**
 * @ClassName: Official20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 17:43
 * @Version: 1.0
 */
public class Official20230209 {

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }

}

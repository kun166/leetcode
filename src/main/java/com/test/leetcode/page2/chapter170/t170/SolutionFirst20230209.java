package com.test.leetcode.page2.chapter170.t170;

import org.junit.Test;

/**
 * @ClassName: Solution20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 17:32
 * @Version: 1.0
 */
public class SolutionFirst20230209 {

    @Test
    public void test() {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int right = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            number += right * (columnTitle.charAt(i) - 'A' + 1);
            right *= 26;
        }
        return number;
    }
}

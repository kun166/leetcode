package com.test.leetcode.page2.chapter170.t170;

import org.junit.Test;

/**
 * @ClassName: StringToNumber
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 17:48
 * @Version: 1.0
 */
public class StringToNumber {

    @Test
    public void test() {
        System.out.println(stringToNumber("208"));
    }


    public int stringToNumber(String columnString) {
        int ant = 0;
        for (int i = 0; i < columnString.length(); i++) {
            ant = ant * 10 + columnString.charAt(i) - '0';
        }
        return ant;
    }
}

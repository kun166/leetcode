package com.test.leetcode.page2.chapter160.t168;

import org.junit.Test;

/**
 * @ClassName: Solution2025032401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 10:47
 * @Version: 1.0
 */
public class Solution2025032401 {

    @Test
    public void test() {
        System.out.println(convertToTitle(26 * 26 + 26));
    }

    /**
     * 这题一定要弄明白,26*26不是ZZ,26*26+26才是ZZ……
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();

        while (columnNumber != 0) {
            columnNumber -= 1;
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return builder.reverse().toString();
    }
}

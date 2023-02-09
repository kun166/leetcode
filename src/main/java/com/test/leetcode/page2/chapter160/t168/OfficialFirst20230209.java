package com.test.leetcode.page2.chapter160.t168;

/**
 * @ClassName: Official20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 10:28
 * @Version: 1.0
 */
public class OfficialFirst20230209 {

    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
}

package com.test.leetcode.page2.chapter160.t168;

/**
 * @ClassName: OfficialSecond20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 10:38
 * @Version: 1.0
 */
public class OfficialSecond20230209 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}

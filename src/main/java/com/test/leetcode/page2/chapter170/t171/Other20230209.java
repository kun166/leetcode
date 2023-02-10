package com.test.leetcode.page2.chapter170.t171;

/**
 * @ClassName: Other20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 17:44
 * @Version: 1.0
 */
public class Other20230209 {

    public int titleToNumber(String columnTitle) {
        int ant = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ant = ant * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return ant;
    }
}

package com.test.leetcode.page1.chapter30.t38;

/**
 * @ClassName: OfficeSolution
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/15 10:35
 * @Version: 1.0
 */
public class OfficeSolution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }
}

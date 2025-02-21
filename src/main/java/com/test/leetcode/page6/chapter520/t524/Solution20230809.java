package com.test.leetcode.page6.chapter520.t524;

import java.util.List;

/**
 * @ClassName: Solution20230809
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/9 15:54
 * @Version: 1.0
 */
public class Solution20230809 {

    /**
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String str : dictionary) {
            if (isSub(s, str)) {
                if (str.length() < ans.length()) {
                    continue;
                }
                if (str.length() > ans.length()) {
                    ans = str;
                    continue;
                }
                if (str.compareTo(ans) < 0) {
                    ans = str;
                }
            }
        }
        return ans;
    }

    private boolean isSub(String str, String sub) {
        int p = 0, q = 0;
        while (p < str.length() && q < sub.length()) {
            if (str.charAt(p) == sub.charAt(q)) {
                q++;
            }
            p++;
        }
        return q == sub.length();
    }
}

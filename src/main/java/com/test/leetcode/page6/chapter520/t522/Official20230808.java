package com.test.leetcode.page6.chapter520.t522;

/**
 * @ClassName: Official20230808
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/8 17:51
 * @Version: 1.0
 */
public class Official20230808 {

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    /**
     * 这方法真的是牛逼啊
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}

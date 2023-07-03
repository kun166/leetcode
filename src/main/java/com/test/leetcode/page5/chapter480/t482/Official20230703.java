package com.test.leetcode.page5.chapter480.t482;

/**
 * @ClassName: Official20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 11:21
 * @Version: 1.0
 */
public class Official20230703 {

    /**
     * 这代码确实好多了
     * 1,从后向前，不用刻意计算最后还剩余几个字符
     * 2,用Character.toUpperCase,比 (char)(c-'a'+'A')高级太多，而且都不需要判断是小写字母
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }
}

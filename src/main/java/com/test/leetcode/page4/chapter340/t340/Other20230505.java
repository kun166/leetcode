package com.test.leetcode.page4.chapter340.t340;

/**
 * @ClassName: Other20230505
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/5 14:58
 * @Version: 1.0
 */
public class Other20230505 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * 通过测试用例：142 / 142
     *
     * @param ss
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String ss, int k) {
        int res = 0;
        int[] hash = new int[128];
        char[] s = ss.toCharArray();
        int cnt = 0;
        for (int i = 0, l = 0; i < s.length; i++) {
            hash[s[i]]++;
            if (hash[s[i]] == 1) {
                cnt++;
            }
            while (cnt > k) {
                hash[s[l]]--;
                if (hash[s[l]] == 0) {
                    cnt--;
                }
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}

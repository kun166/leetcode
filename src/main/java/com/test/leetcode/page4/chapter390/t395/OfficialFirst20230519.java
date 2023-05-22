package com.test.leetcode.page4.chapter390.t395;

/**
 * @ClassName: OfficialFirst20230519
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/19 09:03
 * @Version: 1.0
 */
public class OfficialFirst20230519 {

    /**
     * 方法一：分治
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // 分割的那个字母
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        // 说明从l到r，都满足条件
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}

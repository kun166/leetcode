package com.test.leetcode.page2.chapter130.t131;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230129
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/29 08:53
 * @Version: 1.0
 */
public class OfficialSecond20230129 {

    int[][] f;
    // 返回对象
    List<List<String>> ret = new ArrayList<List<String>>();
    // 记忆字符串列表
    List<String> ans = new ArrayList<String>();
    int n;

    /**
     * 回溯 + 记忆化搜索
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        // 字符串长度
        n = s.length();
        // dp
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 呃
    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}

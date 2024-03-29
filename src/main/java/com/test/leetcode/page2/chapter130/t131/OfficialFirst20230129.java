package com.test.leetcode.page2.chapter130.t131;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230129
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/29 08:51
 * @Version: 1.0
 */
public class OfficialFirst20230129 {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    @Test
    public void test() {
        List<List<String>> list = partition("aab");
        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 回溯 + 动态规划预处理
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        // 给定的字符串长度
        n = s.length();
        // 动态规划。f[i][j]表示字符串中第i个下标到第j个下标的字符串，是否是回文串
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        // 从后往前遍历
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    /**
     * 递归回溯
     *
     * @param s
     * @param i
     */
    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

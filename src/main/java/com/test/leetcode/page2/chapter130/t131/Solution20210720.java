package com.test.leetcode.page2.chapter130.t131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-20 10:47
 */
public class Solution20210720 {

    @Test
    public void test() {
        //List<List<String>> list = partition("aab");
        System.out.println(partition("aabbaa"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }
        List<String> list = new ArrayList<>();
        dfs(f, list, result, 0, s);
        return result;
    }

    public void dfs(boolean[][] f, List<String> list, List<List<String>> result, int index, String s) {
        if (index >= s.length()) {
            List<String> l = new ArrayList<>(list);
            result.add(l);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (f[index][i]) {
                list.add(s.substring(index, i + 1));
                dfs(f, list, result, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
}

package com.test.leetcode.page3.chapter210.t214;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Kms
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/31 08:53
 * @Version: 1.0
 */
public class Kmp {


    @Test
    public void test() {
        String s1 = "aacecaaa";
        int[] kmp = new int[s1.length()];
        int p = 0;
        for (int i = 1; i < kmp.length; i++) {
            while (p > 0 && s1.charAt(i) != s1.charAt(p)) {
                p = kmp[p - 1];
            }
            if (s1.charAt(i) == s1.charAt(p)) {
                p++;
            }
            kmp[i] = p;
        }
        System.out.println(JSON.toJSONString(kmp));
        String s2 = "aaacecaa";
        p = 0;
        for (int i = 1; i < s2.length(); i++) {
            while (p > 0 && s2.charAt(i) != s1.charAt(p)) {
                p = kmp[p - 1];
            }
            if (s2.charAt(i) == s1.charAt(p)) {
                p++;
            }
        }
        System.out.println(p);
    }

    @Test
    public void test1() {
        String s = "aacecaaa";
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        // 求s的PMT
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        System.out.println(JSON.toJSONString(fail));
    }

}

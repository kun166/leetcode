package com.test.leetcode.page1.chapter20.t28;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: KMPSolution20221024
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/24 19:55
 * @Version: 1.0
 */
public class PMTSolution20221024 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(pmt("abababca")));
    }

    public int[] pmt(String s) {
        int n = s.length();
        // pmt[i]标识的是：字符串s从下标0到下标i,这一部分字符串的匹配值
        int[] pmt = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                // 如果不匹配，就看截止到上一个字符串的匹配值，从这个匹配值开始继续匹配
                j = pmt[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                // 匹配就+1
                j++;
            }
            // 字符串s从下标0到当前下标为i的部分字符串的匹配值就是j
            pmt[i] = j;
        }
        return pmt;
    }

}

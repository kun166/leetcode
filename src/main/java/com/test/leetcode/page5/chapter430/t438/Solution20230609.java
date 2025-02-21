package com.test.leetcode.page5.chapter430.t438;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 08:40
 * @Version: 1.0
 */
public class Solution20230609 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findAnagrams("cbaebabacd", "abc")));
    }

    /**
     * 异位词：
     * 1,包含同样多的字符
     * 2,每个字符的数量相同
     * <p>
     * 执行用时：5 ms, 在所有 Java 提交中击败了95.99%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了69.45%的用户
     * 通过测试用例：65 / 65
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return ans;
        }
        // 记录p的字符出现次数
        int[] pArr = new int[26];
        for (char c : p.toCharArray()) {
            pArr[c - 'a']++;
        }
        int[] sArr = new int[26];
        // 不是异位词的情况
        // 1,包含字符多;2,某个字符数量多
        // 双指针
        int left = 0, right = 0;
        while (right < m) {
            char c = s.charAt(right);
            if (pArr[c - 'a'] == 0) {
                // 包含的字符多，直接从下一个字符开始了
                Arrays.fill(sArr, 0);
                left = right + 1;
                right++;
                continue;
            }
            sArr[c - 'a']++;
            while (sArr[c - 'a'] > pArr[c - 'a']) {
                sArr[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == n) {
                ans.add(left);
                sArr[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}

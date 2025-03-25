package com.test.leetcode.page2.chapter180.t187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 09:35
 * @Version: 1.0
 */
public class Solution2025032501 {

    /**
     * 这题不知道是考察啥……
     * 啊哦，超时了……
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10)
            return ans;
        Set<String> set = new HashSet<>();
        int left = 0, right = 10;
        while (right <= s.length()) {
            /**
             * left->right-1
             * 如果right-1在的字符和left-1相同,则说明和前面尝试的字符串相同啊
             */
            if (set.contains(s.substring(left, right))) {
                left++;
                right++;
                continue;
            }
            /**
             * System.out.println("abcdefg".indexOf("ab", 0))
             * 返回的是0,因此这个地方需要left+1
             */
            if (s.indexOf(s.substring(left, right), left + 1) > -1)
                set.add(s.substring(left, right));
            left++;
            right++;
        }
        ans.addAll(set);
        return ans;
    }
}

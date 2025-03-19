package com.test.leetcode.page2.chapter130.t139;

import java.util.*;

/**
 * @ClassName: Solution2025031901
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/19 15:50
 * @Version: 1.0
 */
public class Solution2025031902 {

    boolean ans;

    /**
     * 超出时间限制
     * 看来递归是不太行了啊……
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Collections.sort(wordDict, Comparator.comparingInt(String::length));
        Set<String> strSet = new HashSet<>();
        Set<Integer> lengthSet = new HashSet<>();
        int firstLength = wordDict.get(0).length();
        for (String str : wordDict) {
            if (str.length() == firstLength) {
                strSet.add(str);
                lengthSet.add(str.length());
            } else {
                ans = false;
                backtrack(str, strSet, lengthSet, 0);
                if (!ans) {
                    strSet.add(str);
                    lengthSet.add(str.length());
                }
            }
        }
        ans = false;
        // 匹配
        backtrack(s, strSet, lengthSet, 0);
        return ans;
    }


    public void backtrack(String s, Set<String> strSet, Set<Integer> lengthSet, int index) {
        if (ans)
            return;
        if (index == s.length()) {
            ans = true;
            return;
        }
        for (int length : lengthSet) {
            if (index + length <= s.length() && strSet.contains(s.substring(index, index + length))) {
                backtrack(s, strSet, lengthSet, index + length);
            }
        }
    }
}

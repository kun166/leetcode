package com.test.leetcode.page2.chapter130.t139;

import java.util.*;

/**
 * @ClassName: Solution2025031901
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/19 15:50
 * @Version: 1.0
 */
public class Solution2025031903 {

    boolean ans = false;

    /**
     * 唉唉唉
     * 2ms	击败92.57%
     * 40.76MB	击败97.39%
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strSet = new HashSet<>();
        List<Integer> lengthList = new ArrayList<>();
        Set<Integer> notMatch = new HashSet<>();
        for (String str : wordDict) {
            strSet.add(str);
            if (!lengthList.contains(str.length())) {
                lengthList.add(str.length());
            }
        }
        Collections.sort(lengthList);
        // 匹配
        backtrack(s, strSet, lengthList, 0, notMatch);
        return ans;
    }


    public boolean backtrack(String s, Set<String> strSet, List<Integer> lengthList, int index, Set<Integer> notMatch) {
        if (ans)
            return true;
        if (index == s.length()) {
            ans = true;
            return true;
        }

        for (int i = lengthList.size() - 1; i >= 0; i--) {
            int length = lengthList.get(i);
            if (index + length <= s.length() && !notMatch.contains(index + length) && strSet.contains(s.substring(index, index + length))) {
                boolean match = backtrack(s, strSet, lengthList, index + length, notMatch);
                if (match)
                    return true;
            }
        }
        notMatch.add(index);
        return false;
    }
}

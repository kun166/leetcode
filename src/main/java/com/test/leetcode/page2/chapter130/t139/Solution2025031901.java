package com.test.leetcode.page2.chapter130.t139;

import java.util.*;

/**
 * @ClassName: Solution2025031901
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/19 15:50
 * @Version: 1.0
 */
public class Solution2025031901 {

    boolean ans = false;

    /**
     * 先来个递归-回溯,简单版本的吧
     * <p>
     * 超出时间限制……
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strSet = new HashSet<>();
        List<Integer> lengthList = new ArrayList<>();
        for (String str : wordDict) {
            strSet.add(str);
            if (!lengthList.contains(str.length())) {
                lengthList.add(str.length());
            }
        }
        Collections.sort(lengthList);
        // 匹配
        backtrack(s, strSet, lengthList, 0);
        return ans;
    }


    public void backtrack(String s, Set<String> strSet, List<Integer> lengthList, int index) {
        if (ans)
            return;
        if (index == s.length()) {
            ans = true;
            return;
        }
        for (int i = lengthList.size() - 1; i >= 0; i--) {
            int length = lengthList.get(i);
            if (index + length <= s.length() && strSet.contains(s.substring(index, index + length))) {
                backtrack(s, strSet, lengthList, index + length);
            }
        }
    }
}

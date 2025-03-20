package com.test.leetcode.page2.chapter140.t140;

import java.util.*;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 08:44
 * @Version: 1.0
 */
public class Solution2025032001 {

    /**
     * 先来一个超时的递归-回溯……
     * <p>
     * 呃，你居然告诉我过了？…………
     * 2ms	击败46.43%
     * 40.99MB	击败50.58%
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (String str : wordDict) {
            set.add(str);
            if (!list.contains(str.length()))
                list.add(str.length());
        }
        Collections.sort(list);
        backtrack(s, set, ans, list, new StringBuilder(), 0);
        return ans;
    }


    public void backtrack(String s, Set<String> set, List<String> ans, List<Integer> list, StringBuilder builder, int index) {
        if (index == s.length()) {
            ans.add(builder.deleteCharAt(builder.length() - 1).toString());
            return;
        }
        int builderLength = builder.length();
        for (int length : list) {
            String str;
            if (index + length <= s.length() && set.contains(str = s.substring(index, index + length))) {
                builder.append(str).append(" ");
                backtrack(s, set, ans, list, builder, index + length);
                builder.delete(builderLength, builder.length());
            }
        }
    }
}

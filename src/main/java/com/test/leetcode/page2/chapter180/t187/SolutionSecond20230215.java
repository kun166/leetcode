package com.test.leetcode.page2.chapter180.t187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: SolutionSecond20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 08:34
 * @Version: 1.0
 */
public class SolutionSecond20230215 {

    /**
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        // 呃，这个边界问题很难掌控啊。假设字符串长度为10，则i<s.length()-10的话，就是i=0;i<0,显然是不对的
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                ans.add(str);
                continue;
            }
            set.add(str);
        }
        return new ArrayList<>(ans);
    }
}

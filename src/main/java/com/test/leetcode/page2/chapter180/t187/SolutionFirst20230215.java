package com.test.leetcode.page2.chapter180.t187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Solution20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 08:24
 * @Version: 1.0
 */
public class SolutionFirst20230215 {

    /**
     * 超时了……
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                continue;
            }
            set.add(str);
            if (s.indexOf(str, i + 1) > -1) {
                ans.add(str);
            }
        }
        return ans;
    }
}

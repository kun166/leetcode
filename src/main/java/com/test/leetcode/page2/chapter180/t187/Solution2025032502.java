package com.test.leetcode.page2.chapter180.t187;

import java.util.*;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 09:35
 * @Version: 1.0
 */
public class Solution2025032502 {

    /**
     * 19ms	击败72.45%
     * 52.55MB	击败32.80%
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10)
            return ans;
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 10;
        while (right <= s.length()) {
            String str = s.substring(left++, right++);
            Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else if (count == 1) {
                ans.add(str);
                map.put(str, 2);
            }
        }
        return ans;
    }
}

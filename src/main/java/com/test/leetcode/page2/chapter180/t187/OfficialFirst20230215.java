package com.test.leetcode.page2.chapter180.t187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: OfficialFirst20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 08:44
 * @Version: 1.0
 */
public class OfficialFirst20230215 {

    static final int L = 10;

    /**
     * 这个算法，能保证字符串出现的顺序
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i <= n - L; ++i) {
            String sub = s.substring(i, i + L);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }

}

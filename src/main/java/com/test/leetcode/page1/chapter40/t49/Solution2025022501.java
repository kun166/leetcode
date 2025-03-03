package com.test.leetcode.page1.chapter40.t49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20250225
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 16:21
 * @Version: 1.0
 */
public class Solution2025022501 {

    /**
     * 只能双层循环么
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = getStr(strs[i]);
            if (!map.containsKey(str)) {
                map.put(str, ans.size());
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                ans.add(list);
            } else {
                ans.get(map.get(str)).add(strs[i]);
            }
        }
        return ans;
    }

    public String getStr(String str) {
        int[] array = new int[26];
        for (char c : str.toCharArray()) {
            array[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                builder.append(array[i]).append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }
}

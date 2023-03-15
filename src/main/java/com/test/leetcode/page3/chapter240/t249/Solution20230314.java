package com.test.leetcode.page3.chapter240.t249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 16:46
 * @Version: 1.0
 */
public class Solution20230314 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了47.78%的用户
     *
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = getString(str);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }

    public String getString(String str) {
        if (str.length() == 1) {
            return "1";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int number = str.charAt(i) - str.charAt(i - 1);
            number = number >= 0 ? number : number + 26;
            builder.append(number).append("-");
        }
        return builder.toString();
    }
}

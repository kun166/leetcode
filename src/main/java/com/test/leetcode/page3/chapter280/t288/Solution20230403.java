package com.test.leetcode.page3.chapter280.t288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution20230403
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/3 09:04
 * @Version: 1.0
 */
public class Solution20230403 {

    /**
     * 执行用时：59 ms, 在所有 Java 提交中击败了93.67%的用户
     * 内存消耗：51.1 MB, 在所有 Java 提交中击败了30.38%的用户
     * 通过测试用例：49 / 49
     */
    class ValidWordAbbr {
        Map<String, Set<String>> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String str : dictionary) {
                String key = getKey(str);
                Set<String> set = map.get(key);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(key, set);
                }
                set.add(str);
            }
        }

        public boolean isUnique(String word) {
            String key = getKey(word);
            Set<String> set = map.get(key);
            if (set == null || (set.size() == 1 && set.contains(word))) {
                return true;
            }
            return false;
        }

        private String getKey(String str) {
            if (str.length() <= 2) {
                return str;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(str.charAt(0));
            builder.append(str.length() - 2);
            builder.append(str.charAt(str.length() - 1));
            return builder.toString();
        }
    }


}

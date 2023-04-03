package com.test.leetcode.page3.chapter290.t290;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230403
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/3 10:59
 * @Version: 1.0
 */
public class Solution20230403 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了17.42%的用户
     * 通过测试用例：41 / 41
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if (array.length != pattern.length()) {
            return false;
        }
        Map<Character, String> cToStrMap = new HashMap<>();
        Map<String, Character> strToCMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String str = array[i];
            Character cP = strToCMap.get(str);
            String strP = cToStrMap.get(c);
            if (cP == null && strP == null) {
                cToStrMap.put(c, str);
                strToCMap.put(str, c);
                continue;
            }
            if (c.equals(cP) && str.equals(strP)) {
                continue;
            }
            return false;
        }
        return true;
    }
}

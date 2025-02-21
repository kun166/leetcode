package com.test.leetcode.page6.chapter500.t500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20230712
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/12 09:25
 * @Version: 1.0
 */
public class Solution20230712 {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        for (char c : "qwertyuiop".toCharArray()) {
            map.put(c, 1);
            map.put(Character.toUpperCase(c), 1);
        }

        for (char c : "asdfghjkl".toCharArray()) {
            map.put(c, 2);
            map.put(Character.toUpperCase(c), 2);
        }

        for (char c : "zxcvbnm".toCharArray()) {
            map.put(c, 3);
            map.put(Character.toUpperCase(c), 3);
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了35.86%的用户
     * 通过测试用例：23 / 23
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String str : words) {
            boolean check = true;
            int first = map.get(str.charAt(0));
            for (char c : str.toCharArray()) {
                if (first != map.get(c)) {
                    check = false;
                }
            }
            if (check) {
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

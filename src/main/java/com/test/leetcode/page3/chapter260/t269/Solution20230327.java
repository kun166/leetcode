package com.test.leetcode.page3.chapter260.t269;

import java.util.*;

/**
 * @ClassName: Solution20230327
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/27 10:08
 * @Version: 1.0
 */
public class Solution20230327 {
    public String alienOrder(String[] words) {
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (String str : words) {
            // 查找第一个字符
            if (!set.contains(str.charAt(0))) {
                set.add(str.charAt(0));
                list.add(str.charAt(0));
            } else if (str.charAt(0) != list.get(list.size() - 1)) {
                // 如果已存在，判断是否排序有问题
                return "";
            }
        }
        // 排序吧
        Arrays.sort(words);
        for (int i = 1; i < words.length; i++) {
            // 如果不是第一个字符相同，则没法比较
            if (words[i].charAt(0) != words[i - 1].charAt(0)) {
                continue;
            }

        }
        return null;
    }
}

package com.test.leetcode.page1.chapter30.t30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Office20221027
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/27 10:49
 * @Version: 1.0
 */
public class Office20221027 {

    public List<Integer> findSubstring(String s, String[] words) {
        // 返回结果
        List<Integer> res = new ArrayList<Integer>();
        // 定义字符串数组长度，每个字符串的长度，字符串s的长度
        int m = words.length, n = words[0].length(), ls = s.length();
        // 遍历字符串s中的每一个字符
        for (int i = 0; i < n; i++) {
            // 快速失败，如果长度不符合要求就快速失败
            if (i + m * n > ls) {
                break;
            }
            // 存放从i开始，每n个字符切割的字符串，value是该字符串出现的数量
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                // 对s进行每n个字符切割
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            // 然后再对words数组进行遍历处理
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

}

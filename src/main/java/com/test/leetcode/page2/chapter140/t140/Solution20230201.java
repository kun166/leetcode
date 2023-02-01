package com.test.leetcode.page2.chapter140.t140;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Solution20230201
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/1 10:20
 * @Version: 1.0
 */
public class Solution20230201 {

    @Test
    public void test() {
        List<String> list = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        System.out.println(JSON.toJSONString(wordBreak("catsanddog", list)));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, Set<String>> map = new HashMap<>();
        int maxLength = 0;
        for (String str : wordDict) {
            Set<String> set = map.get(str.length());
            if (set == null) {
                set = new HashSet<>();
                map.put(str.length(), set);
            }
            set.add(str);
            maxLength = Math.max(maxLength, str.length());
        }
        List<String> list = new ArrayList<>();
        wordBreak(s, map, 0, list, new StringBuilder(), maxLength);
        return list;
    }

    public void wordBreak(String s,
                          Map<Integer, Set<String>> map,
                          int index,
                          List<String> list,
                          StringBuilder builder,
                          int maxLength) {
        for (int i = index; i < index + maxLength && i < s.length(); i++) {
            Set<String> set = map.get(i - index + 1);
            if (set == null) {
                continue;
            }
            String str = s.substring(index, i + 1);
            if (set.contains(str)) {
                int count = builder.length();
                if (i == s.length() - 1) {
                    // 最后一个
                    builder.append(str);
                    list.add(builder.toString());
                    builder.delete(count, builder.length());
                } else {
                    builder.append(str).append(" ");
                    wordBreak(s, map, i + 1, list, builder, maxLength);
                    builder.delete(count, builder.length());
                }
            }
        }
    }
}

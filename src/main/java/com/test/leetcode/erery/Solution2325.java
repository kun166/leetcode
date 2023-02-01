package com.test.leetcode.erery;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2325
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/1 09:24
 * @Version: 1.0
 */
public class Solution2325 {

    @Test
    public void test() {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }


    public String decodeMessage(String key, String message) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, count++);
            }
        }
        System.out.println(JSON.toJSONString(map));
        StringBuilder builder = new StringBuilder();
        for (char c : message.toCharArray()) {
            Integer index = map.get(c);
            if (index != null) {
                builder.append((char) ('a' - 0 + index));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}

package com.test.leetcode.page2.chapter180.t187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 09:35
 * @Version: 1.0
 */
public class Solution2025032503 {

    /**
     * 再精简一下:
     * 就四个字符,'A','C','G'和'T'.且长度不超过10个
     * <p>
     * <p>
     * 唉唉唉，这个解法是错误的……因为有顺序
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10)
            return ans;
        /**
         * 呃,这个地方没法借鉴137题……
         * 下面这种设法不行
         * Map<Character, Integer> valueMap = new HashMap<>();
         * valueMap.put('A', 1);
         * valueMap.put('C', 2);
         * valueMap.put('G', 3);
         * valueMap.put('T', 4);
         * 会存在一个A+一个G 和两个C相等……
         */
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('A', 1);
        valueMap.put('C', 10);
        valueMap.put('G', 100);
        valueMap.put('T', 1000);
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value += valueMap.get(s.charAt(i));
        }
        map.put(value, 1);
        /**
         * 上面是统计的0-9前10个字符的值
         * 下面从第11个字符,即下标为10的字符开始
         */
        int index = 10;
        while (index < s.length()) {
            /**
             * 新添加一个下标为index的字符
             * 尾部去掉一个下标为index-10的字符
             */
            value += valueMap.get(s.charAt(index));
            value -= valueMap.get(s.charAt(index - 10));
            Integer count = map.get(value);
            if (count == null) {
                map.put(value, 1);
            } else if (count == 1) {
                ans.add(s.substring(index - 9, index + 1));
                map.put(value, 2);
            }
            index++;
        }
        return ans;
    }
}

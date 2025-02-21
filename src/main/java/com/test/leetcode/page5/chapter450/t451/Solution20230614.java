package com.test.leetcode.page5.chapter450.t451;

import java.util.*;

/**
 * @ClassName: Solution20230614
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/14 09:06
 * @Version: 1.0
 */
public class Solution20230614 {

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了89.14%的用户
     * 内存消耗：42.7 MB, 在所有 Java 提交中击败了41.73%的用户
     * 通过测试用例：33 / 33
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        List<CharAndCount> list = new ArrayList<>();
        Map<Character, CharAndCount> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.get(c).count++;
            } else {
                CharAndCount cac = new CharAndCount(c, 1);
                map.put(c, cac);
                list.add(cac);
            }
        }
        Collections.sort(list, new Comparator<CharAndCount>() {
            @Override
            public int compare(CharAndCount o1, CharAndCount o2) {
                return o2.count - o1.count;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (CharAndCount cac : list) {
            for (int i = 0; i < cac.count; i++) {
                builder.append(cac.c);
            }
        }
        return builder.toString();
    }
}

class CharAndCount {
    char c;
    int count;

    CharAndCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

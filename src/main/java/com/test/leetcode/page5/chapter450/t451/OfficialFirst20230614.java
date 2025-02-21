package com.test.leetcode.page5.chapter450.t451;

import java.util.*;

/**
 * @ClassName: OfficialFirst20230614
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/14 09:25
 * @Version: 1.0
 */
public class OfficialFirst20230614 {

    /**
     * 方法一：按照出现频率排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        // 这个操作，我只能说，特别的骚
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

package com.test.leetcode.page3.chapter260.t269;

import java.util.*;

/**
 * @ClassName: OfficialSecond20230328
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/28 09:11
 * @Version: 1.0
 */
public class OfficialSecond20230328 {

    /**
     * 方法二：拓扑排序 + 广度优先搜索
     */
    class Solution {
        Map<Character, List<Character>> edges = new HashMap<Character, List<Character>>();
        Map<Character, Integer> indegrees = new HashMap<Character, Integer>();
        boolean valid = true;

        public String alienOrder(String[] words) {
            int length = words.length;
            for (String word : words) {
                int wordLength = word.length();
                for (int j = 0; j < wordLength; j++) {
                    char c = word.charAt(j);
                    edges.putIfAbsent(c, new ArrayList<Character>());
                }
            }
            for (int i = 1; i < length && valid; i++) {
                addEdge(words[i - 1], words[i]);
            }
            if (!valid) {
                return "";
            }
            Queue<Character> queue = new ArrayDeque<Character>();
            Set<Character> letterSet = edges.keySet();
            for (char u : letterSet) {
                if (!indegrees.containsKey(u)) {
                    queue.offer(u);
                }
            }
            StringBuffer order = new StringBuffer();
            while (!queue.isEmpty()) {
                char u = queue.poll();
                order.append(u);
                List<Character> adjacent = edges.get(u);
                for (char v : adjacent) {
                    indegrees.put(v, indegrees.get(v) - 1);
                    if (indegrees.get(v) == 0) {
                        queue.offer(v);
                    }
                }
            }
            return order.length() == edges.size() ? order.toString() : "";
        }

        public void addEdge(String before, String after) {
            int length1 = before.length(), length2 = after.length();
            int length = Math.min(length1, length2);
            int index = 0;
            while (index < length) {
                char c1 = before.charAt(index), c2 = after.charAt(index);
                if (c1 != c2) {
                    edges.get(c1).add(c2);
                    indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                    break;
                }
                index++;
            }
            if (index == length && length1 > length2) {
                valid = false;
            }
        }
    }
}

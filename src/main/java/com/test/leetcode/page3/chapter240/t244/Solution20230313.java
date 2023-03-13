package com.test.leetcode.page3.chapter240.t244;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 20:30
 * @Version: 1.0
 */
public class Solution20230313 {

    @Test
    public void test() {
        WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(wordDistance.shortest("coding", "practice"));
        System.out.println(wordDistance.shortest("makes", "coding"));
    }

    /**
     * 执行用时：27 ms, 在所有 Java 提交中击败了85.93%的用户
     * 内存消耗：48.1 MB, 在所有 Java 提交中击败了40.00%的用户
     */
    class WordDistance {
        Map<String, List<Integer>> map;

        public WordDistance(String[] wordsDict) {
            map = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                List<Integer> list = map.get(wordsDict[i]);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(wordsDict[i], list);
                }
                list.add(i);
            }
        }

        public int shortest(String word1, String word2) {
            int min = Integer.MAX_VALUE;
            for (int x : map.get(word1)) {
                int l = Integer.MAX_VALUE;
                for (int y : map.get(word2)) {
                    int m = Math.abs(x - y);
                    if (l > m) {
                        l = m;
                        min = Math.min(min, l);
                    } else {
                        break;
                    }
                }
            }
            return min;
        }
    }
}

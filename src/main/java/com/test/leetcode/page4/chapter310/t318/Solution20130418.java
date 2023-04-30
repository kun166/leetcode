package com.test.leetcode.page4.chapter310.t318;

import java.util.*;

/**
 * @ClassName: Solution20130418
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/18 09:02
 * @Version: 1.0
 */
public class Solution20130418 {

    /**
     * 执行用时：180 ms, 在所有 Java 提交中击败了15.46%的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了5.02%的用户
     * 通过测试用例：168 / 168
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int ans = 0;
        Map<Integer, List<Word>> map = new HashMap<>();
        for (String w : words) {
            Word word = new Word(w);
            if (word.set.size() == 26) {
                continue;
            }
            List<Word> list = map.get(w.length());
            if (list == null) {
                list = new ArrayList<>();
                map.put(w.length(), list);
            }
            list.add(word);
        }

        // 拿到key列表，然后排序
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (t1, t2) -> -t1.compareTo(t2));
        // 遍历整个map 的key值
        for (int i = 0; i < keyList.size(); i++) {
            // 取出当前key值对应的list
            List<Word> list = map.get(keyList.get(i));
            for (int j = 0; j < list.size(); j++) {
                Word word1 = list.get(j);
                for (int m = j + 1; m < list.size(); m++) {
                    Word word2 = list.get(m);
                    if (word1.str.length() * word2.str.length() <= ans) {
                        continue;
                    }
                    // 判断是否有交集
                    boolean has = false;
                    for (char c1 : word1.str.toCharArray()) {
                        if (word2.set.contains(c1)) {
                            has = true;
                            break;
                        }
                    }
                    if (!has) {
                        ans = Math.max(ans, word1.str.length() * word2.str.length());
                    }
                }
                for (int m = i + 1; m < keyList.size(); m++) {
                    List<Word> list2 = map.get(keyList.get(m));
                    for (int n = 0; n < list2.size(); n++) {
                        Word word2 = list2.get(n);
                        if (word1.str.length() * word2.str.length() <= ans) {
                            continue;
                        }
                        // 判断是否有交集
                        boolean has = false;
                        for (char c1 : word1.str.toCharArray()) {
                            if (word2.set.contains(c1)) {
                                has = true;
                                break;
                            }
                        }
                        if (!has) {
                            ans = Math.max(ans, word1.str.length() * word2.str.length());
                        }
                    }
                }
            }
        }
        return ans;
    }

    class Word {
        String str;
        Set<Character> set = new HashSet<>();

        Word(String w) {
            str = w;
            for (char c : w.toCharArray()) {
                set.add(c);
            }
        }
    }
}

package com.test.leetcode.page2.chapter120.t126;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Solution20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 20:55
 * @Version: 1.0
 */
public class Solution20230127 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        boolean[] used = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index > -1) {
            used[index] = true;
        }
        List<String> l = new ArrayList<>();
        l.add(beginWord);
        findLadders(beginWord, endWord, wordList, ans, l, used);
        if (ans.size() > 0) {
            int minSize = ans.get(0).size();
            for (int i = 1; i < ans.size(); i++) {
                minSize = Math.min(minSize, ans.get(i).size());
            }
            Iterator<List<String>> iterator = ans.iterator();
            while (iterator.hasNext()) {
                List<String> list = iterator.next();
                if (list.size() != minSize) {
                    iterator.remove();
                }
            }
        }
        return ans;
    }

    public void findLadders(String beginWord,
                            String endWord,
                            List<String> wordList,
                            List<List<String>> ans,
                            List<String> list,
                            boolean[] used) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (used[i]) {
                continue;
            }
            String s = wordList.get(i);
            if (match(beginWord, s)) {
                list.add(s);
                used[i] = true;
                findLadders(s, endWord, wordList, ans, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public boolean match(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

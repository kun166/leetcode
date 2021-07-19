package com.test.leetcode.chapter120.t126;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-13 19:26
 */
public class Solution {

    @Test
    public void test() {
        List<String> l = Arrays.asList(new String[]{"hot", "dog", "dot"});
        List<String> wordList = new ArrayList<>(l);
        List<List<String>> result = findLadders("hot", "dog", wordList);
        for (List<String> list : result) {
            System.out.println(JSON.toJSONString(list));
        }
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        int dif = dif(beginWord, endWord);
        List<String> wList = new ArrayList<>();
        wList.add(beginWord);
        findLadders(beginWord, endWord, wordList, wList, result, dif);
        int size = Integer.MAX_VALUE;
        for (List<String> l : result) {
            size = Math.min(size, l.size());
        }
        Iterator<List<String>> iterator = result.iterator();
        while (iterator.hasNext()) {
            List<String> l = iterator.next();
            if (l.size() > size) {
                iterator.remove();
            }
        }
        return result;
    }

    public void findLadders(String beginWord,
                            String endWord,
                            List<String> wordList,
                            List<String> wList,
                            List<List<String>> result,
                            int dif) {
        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            String word = wordList.get(i);
            if (match(beginWord, word)) {
                int d = dif(word, endWord);
                if (d > dif) {
                    continue;
                }
                wordList.remove(i);
                wList.add(word);
                if (word.equals(endWord)) {
                    List<String> list = new ArrayList<>();
                    list.addAll(wList);
                    result.add(list);
                } else {
                    findLadders(word, endWord, wordList, wList, result, d);
                }
                wList.remove(wList.size() - 1);
                wordList.add(i, word);
            }
        }
    }

    public boolean match(String beginWord, String endWord) {
        int dif = 0;
        int length = beginWord.length();
        for (int i = 0; i < length; i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) {
                if (dif == 1)
                    return false;
                dif++;
            }
        }
        return dif == 1;
    }

    public int dif(String beginWord, String endWord) {
        int dif = 0;
        int length = beginWord.length();
        for (int i = 0; i < length; i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) {
                dif++;
            }
        }
        return dif;
    }
}

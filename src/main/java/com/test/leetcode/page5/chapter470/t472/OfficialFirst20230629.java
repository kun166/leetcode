package com.test.leetcode.page5.chapter470.t472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230629
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/29 10:43
 * @Version: 1.0
 */
public class OfficialFirst20230629 {

    Trie trie = new Trie();

    /**
     * 判断一个单词是不是连接词，需要判断这个单词是否完全由至少两个给定数组中的更短的非空单词（可以重复）组成。
     * 判断更短的单词是否在给定数组中，可以使用字典树实现。
     *
     * @param words
     * @return
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        // 先排序，字符串长度小的在前面
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            // 获取当前字符串
            String word = words[i];
            // 如果字符串长度为0，则跳过
            if (word.length() == 0) {
                continue;
            }
            // 是否访问过
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, 0, visited)) {
                // 如果是连接词，加入到ans中
                ans.add(word);
            } else {
                // 不是连接词，加入到字典树中
                insert(word);
            }
        }
        return ans;
    }

    /**
     * 判断是否是连接词
     *
     * @param word    当前单词
     * @param start   开始位置
     * @param visited 点位是否已经遍历过
     * @return
     */
    public boolean dfs(String word, int start, boolean[] visited) {
        if (word.length() == start) {
            // 说明当前word遍历结束，是一个连接词
            return true;
        }
        if (visited[start]) {
            // 当前点位遍历过
            return false;
        }
        // 设置当前点位已经访问过
        visited[start] = true;
        // 获取字典树
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            // 从start开始遍历
            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                // 如果当前字符在字典树中不存在，则返回false
                return false;
            }
            if (node.isEnd) {
                // 如果在字典树中存在，且是isEnd,则寻找剩余的字符串是否在字典树中
                if (dfs(word, i + 1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

/**
 * 字典树，代码写不出来，起码知道名字吧？汗，这名字也都老忘
 */
class Trie {
    // 下一个字符
    Trie[] children;
    // 是否是终结点
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

}

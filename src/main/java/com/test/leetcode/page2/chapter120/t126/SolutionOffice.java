package com.test.leetcode.page2.chapter120.t126;


import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-14 10:24
 */
public class SolutionOffice {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 返回对象
        List<List<String>> res = new ArrayList<>();
        // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
        Set<String> dict = new HashSet<>(wordList);
        // 特殊用例判断。如果不存在endWord就直接返回了
        if (!dict.contains(endWord)) {
            return res;
        }
        // 把beginWord去掉
        dict.remove(beginWord);

        // 第 1 步：广度优先遍历建图
        // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先遍历的第几层
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
        Map<String, List<String>> from = new HashMap<>();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();

        // 回溯算法？
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 这个地方也是一个回溯
                String currWord = queue.poll();
                // 当前词的所有字符
                char[] charArray = currWord.toCharArray();
                // 将每一位替换成 26 个小写英文字母
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        // 转换后的词
                        String nextWord = String.valueOf(charArray);
                        // 如果当前转换后的词已经在steps中了，且
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord)) {
                            // 如果该单词不在字典里，就直接下次循环了
                            continue;
                        }
                        // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                        dict.remove(nextWord);
                        // 这一层扩展出的单词进入队列
                        queue.offer(nextWord);

                        // 记录 nextWord 从 currWord 而来
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currWord);
                        // 记录 nextWord 的 step
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    // 回溯
                    charArray[j] = origin;
                }
            }
            step++;
            if (found) {
                break;
            }
        }

        // 第 2 步：深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, res);
        }
        return res;
    }

    public void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(cur)) {
            path.addFirst(precursor);
            dfs(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }
}

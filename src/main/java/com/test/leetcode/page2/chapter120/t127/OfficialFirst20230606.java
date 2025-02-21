package com.test.leetcode.page2.chapter120.t127;

import java.util.*;

/**
 * @ClassName: OfficialFirst20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 17:07
 * @Version: 1.0
 */
public class OfficialFirst20230606 {

    // key是字符串，value是在edge里面的序号
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    // 边的关系，edge的序号是wordId的value，也即edge的序号其实对应一个String
    // 然后edge的每一个序号对应的List<Integer>，其实是边的关系。
    // 建立了 String和List<String>的关系
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    // wordId的value值，递增
    int nodeNum = 0;

    /**
     * 方法一：广度优先搜索 + 优化建图
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        // nodeNum表示一共有多少个点
        int[] dis = new int[nodeNum];
        // 初始化最大值
        Arrays.fill(dis, Integer.MAX_VALUE);
        // 获取beginWord和endWord对应的索引
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                // 对于hit到dot,hit先到h*t,h*t到hot,hot到*ot,*ot到dot
                // 当搜索到终点时，我们就找到了最短路径的长度。注意因为添加了虚拟节点，
                // 所以我们得到的距离为实际最短路径长度的两倍。同时我们并未计算起点对答案的贡献，
                // 所以我们应当返回距离的一半再加一的结果。
                // hit->hot算2，而不是1
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                // 寻找x对应的所有的边的另一边的点
                if (dis[it] == Integer.MAX_VALUE) {
                    // 如果it还没初始化，意思就是以前没到过这点，就初始化这个点
                    // 如果已经到过这个点了，就不再计算了
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    /**
     * 建立word的边
     *
     * @param word
     */
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        // word的字符数组
        char[] array = word.toCharArray();
        // word长度
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            // 替换word的每一个位置上的字符为'*'
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            // 还原array
            array[i] = tmp;
        }
    }

    /**
     * 添加word到map中。位图
     *
     * @param word
     */
    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

}

package com.test.leetcode.page5.chapter430.t433;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName: OfficialFirst20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 15:52
 * @Version: 1.0
 */
public class OfficialFirst20230606 {

    /**
     * 方法一：广度优先搜索
     * 呃，感觉相当的牛逼啊
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        // 这个是bank的set,用户hash快速查找
        Set<String> cnt = new HashSet<String>();
        // 访问过的cnt中的字符串
        Set<String> visited = new HashSet<String>();
        // 每一个位上只能有这四种字符
        char[] keys = {'A', 'C', 'G', 'T'};
        for (String w : bank) {
            cnt.add(w);
        }
        if (start.equals(end)) {
            // 如果start和end一致，则返回0
            return 0;
        }
        if (!cnt.contains(end)) {
            // 如果给的有效数组bank中不包含end，则肯定无法转换到bank
            return -1;
        }
        // 这个用来记录可以到达的字符串,用于广度搜索
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(start);
        // 搜索过的字符串
        visited.add(start);
        // 需要变化的步数
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                // 这相当于层序遍历
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    // 遍历字符串的每一位(一共有8位)
                    for (int k = 0; k < 4; k++) {
                        // 每一位有4种可能
                        if (keys[k] != curr.charAt(j)) {
                            // 如果单签字符串的第j位和key中的字符不一致，就替换
                            // 下面这种写法学着点啊
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                // 如果新的字符串未被访问，且是合法的
                                if (next.equals(end)) {
                                    // 相等
                                    return step;
                                }
                                // 不相等则加入到下一次循环中
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            // 注意这个step的递增时机
            step++;
        }
        return -1;
    }
}

package com.test.leetcode.page5.chapter440.t444;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName: Official20230612
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/12 09:43
 * @Version: 1.0
 */
public class Official20230612 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        // 入度
        int[] indegrees = new int[n + 1];
        // 图
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                // 获取相邻的两个点。如果prev的HaseSet能够添加next,则next的入度加1
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                // 找到所有入度为0的，作为起点尝试
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                // 入度等于0的大于1个？
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

}

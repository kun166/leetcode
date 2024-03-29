package com.test.leetcode.page3.chapter210.t210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230222
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/22 09:38
 * @Version: 1.0
 */
public class OfficialSecond20230222 {
    class Solution {
        // 存储有向图
        List<List<Integer>> edges;
        // 存储每个节点的入度
        int[] indeg;
        // 存储答案
        int[] result;
        // 答案下标
        int index;

        /**
         * 方法二：广度优先搜索
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            // 将所有入度为 0 的节点放入队列中
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                // 从队首取出一个节点
                int u = queue.poll();
                // 放入答案中
                result[index++] = u;
                for (int v : edges.get(u)) {
                    --indeg[v];
                    // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            if (index != numCourses) {
                return new int[0];
            }
            return result;
        }
    }
}

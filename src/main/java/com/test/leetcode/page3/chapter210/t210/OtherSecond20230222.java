package com.test.leetcode.page3.chapter210.t210;

import java.util.Stack;

/**
 * @ClassName: OtherSecond20230222
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/22 09:51
 * @Version: 1.0
 */
public class OtherSecond20230222 {

    /**
     * 方法 2：邻接矩阵 + DFS   由于用的数组，每次都要遍历，效率比较低
     * <p>
     * 1,建立邻接矩阵
     * 2,DFS 访问每一个课程，若存在环直接返回
     * status 保存课程的访问状态，同一个栈保存课程的访问序列。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        // 建立邻接矩阵
        int[][] graph = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[1]][p[0]] = 1;
        }
        // 记录访问状态的数组，访问过了标记 -1，正在访问标记 1，还未访问标记 0
        int[] status = new int[numCourses];
        // 用栈保存访问序列
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, status, i, stack))
                return new int[0]; // 只要存在环就返回
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] status, int i, Stack<Integer> stack) {
        // 当前节点在此次 dfs 中正在访问，说明存在环
        if (status[i] == 1)
            return false;
        if (status[i] == -1)
            return true;

        status[i] = 1;
        for (int j = 0; j < graph.length; j++) {
            // dfs 访问当前课程的后续课程，看是否存在环
            if (graph[i][j] == 1 && !dfs(graph, status, j, stack))
                return false;
        }
        status[i] = -1;  // 标记为已访问
        stack.push(i);
        return true;
    }
}

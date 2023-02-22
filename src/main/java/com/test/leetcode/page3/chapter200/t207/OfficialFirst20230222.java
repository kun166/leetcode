package com.test.leetcode.page3.chapter200.t207;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230222
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/22 08:42
 * @Version: 1.0
 */
public class OfficialFirst20230222 {

    // 边缘？
    List<List<Integer>> edges;
    // 是否访问过？
    int[] visited;
    // 是否已经完成学习?
    boolean valid = true;

    /**
     * 方法一：深度优先搜索
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            // 这个内存占用有点大吧？10万个？
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            // 注意，对于info的{x,y}, 这个是以 必须先完成学习的课程y为下标，把x添加到集合里面去。
            // 也即将来如果y满足了，那么y下标对应的那些所有x的集合如果不再依赖其它的课程，那么它们就可以学习了
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            // 数组visited没有初始化，默认值都是0，即还没有访问过
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    /**
     * 深度优先遍历
     *
     * @param u
     */
    public void dfs(int u) {
        // 下标为u的这个位置访问过
        visited[u] = 1;
        // 遍历依赖下标u课程的那些课程集合
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                // 如果这门课程没有访问过，继续深度遍历
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 如果已经访问过了，说明形成循环了
                valid = false;
                return;
            }
        }
        // 说明这个有向链表已经完成了，没有环
        visited[u] = 2;
    }
}

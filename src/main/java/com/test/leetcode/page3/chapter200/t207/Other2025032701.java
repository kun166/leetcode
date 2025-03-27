package com.test.leetcode.page3.chapter200.t207;

import java.util.*;

/**
 * @ClassName: Other2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 17:55
 * @Version: 1.0
 */
public class Other2025032701 {

    /**
     * https://leetcode.cn/problems/course-schedule/solutions/250377/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/
     * <p>
     * 有向图有 入度 和 出度 的概念：
     * 如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度。
     * <p>
     * 8ms	击败28.05%
     * 45.16MB	击败7.71%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数组，用于记录每门课程的入度
        int[] inDegree = new int[numCourses];
        // 邻接表，存储每门课程的后续课程
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // 计算每门课程的入度，并构建邻接表
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            inDegree[course]++;
            map.get(preCourse).add(course);
        }

        // 存储入度为 0 的课程的队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 记录已完成课程的数量
        int count = 0;
        while (!queue.isEmpty()) {
            int selectedCourse = queue.poll();
            count++;
            // 获取当前课程的后续课程列表
            List<Integer> nextCourses = map.get(selectedCourse);
            for (int nextCourse : nextCourses) {
                // 后续课程的入度减 1
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果已完成课程的数量等于总课程数，则可以完成所有课程
        return count == numCourses;
    }


}

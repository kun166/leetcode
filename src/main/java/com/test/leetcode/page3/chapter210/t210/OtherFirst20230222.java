package com.test.leetcode.page3.chapter210.t210;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OtherFirst20230222
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/22 09:40
 * @Version: 1.0
 */
public class OtherFirst20230222 {


    /**
     * 方法 1 BFS,广度优先
     * 1,建立入度表，入度为 0 的节点先入队
     * 2,当队列不为空，节点出队，标记学完课程数量的变量加 1，并记录该课程
     * 3,将课程的邻居入度减 1
     * 4,若邻居课程入度为 0，加入队列
     * 用一个变量记录学完的课程数量，一个数组记录最终结果，简洁好理解。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        // 入度表，记录当前下标的课程需要的先决课程数量
        int[] inDegrees = new int[numCourses];
        // 初始化入度表
        for (int[] p : prerequisites) {
            // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        // 记录可以学完的课程数量
        int count = 0;
        // 可以学完的课程
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            // 根据提供的先修课列表，删除入度为 0 的节点
            int curr = queue.poll();
            // 将可以学完的课程加入结果当中
            res[count++] = curr;
            // 下面这个for循环太重了，感觉可以用map替代
            for (int[] p : prerequisites) {
                // 遍历所有先决课程条件表，寻找先决课程是当前课程的那些课程，使它们的入度-1
                if (p[1] == curr) {
                    inDegrees[p[0]]--;
                    // 如果入度为0了，则就可以学习了
                    if (inDegrees[p[0]] == 0)
                        queue.offer(p[0]);
                }
            }
        }
        // 如果可以学习的课程数量为全部课程数量，则返回res
        if (count == numCourses)
            return res;
        return new int[0];
    }


}

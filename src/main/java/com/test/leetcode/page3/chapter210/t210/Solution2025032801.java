package com.test.leetcode.page3.chapter210.t210;

import java.util.*;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 10:20
 * @Version: 1.0
 */
public class Solution2025032801 {


    /**
     * 6ms	击败38.03%
     * 45.05MB	击败39.52%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        /**
         * 课程入度,下标是课程,值为入度值
         */
        int[] inDeep = new int[numCourses];

        /**
         * key:当前课程
         * value:当前课程的后置课程,即学习value的课程的时候,必须先学习完当前课程
         */
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            map.put(i, new ArrayList<>());
        }

        for (int[] a : prerequisites) {
            ++inDeep[a[0]];
            map.get(a[1]).add(a[0]);
        }

        LinkedList<Integer> ll = new LinkedList<>();
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (inDeep[i] == 0) {
                ans[++index] = i;
                ll.offer(i);
            }
        }

        while (!ll.isEmpty()) {
            for (int i : map.get(ll.pop())) {
                --inDeep[i];
                if (inDeep[i] == 0) {
                    ans[++index] = i;
                    ll.offer(i);
                }
            }
        }
        /**
         * 呃,如果没法学完课程,返回是new int[0]
         * 而不是new int[numCourses]
         */
        return index == numCourses - 1 ? ans : new int[0];
    }
}

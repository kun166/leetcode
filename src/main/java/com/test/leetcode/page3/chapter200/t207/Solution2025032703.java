package com.test.leetcode.page3.chapter200.t207;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 15:22
 * @Version: 1.0
 */
public class Solution2025032703 {

    @Test
    public void test() {
        System.out.println(canFinish(7, new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}));
    }

    /**
     * 呃,以为是并查集……
     * 看了答案好像不是……
     * <p>
     * 呃,尝试下面的组合失败了
     * 7,{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}
     * 输出:false
     * 预期:true
     * <p>
     * 呃,超出时间限制
     * <p>
     * 20ms	击败10.35%
     * 44.42MB	击败39.09%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 两个map
         * 第一个map,key是当前课程,value是学习key课程,需要学习的课程集合--即前置课程集合
         * 第二个map,key是当前课程,value是需要先学习key课程,才能学习的课程集合
         */
        Map<Integer, Set<Integer>> needStudyMap = new HashMap<>();
        Map<Integer, Set<Integer>> canStudyMap = new HashMap<>();
        for (int[] array : prerequisites) {
            Set<Integer> needValue = needStudyMap.getOrDefault(array[0], new HashSet<>());
            needValue.add(array[1]);
            needStudyMap.put(array[0], needValue);

            Set<Integer> canValue = canStudyMap.getOrDefault(array[1], new HashSet<>());
            canValue.add(array[0]);
            canStudyMap.put(array[1], canValue);
        }
        // 第一次循环初始化canStudySet
        Set<Integer> canStudySet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!needStudyMap.containsKey(i)) {
                // 说明当前课程没有前置课程,可以学习
                canStudySet.add(i);
                initCanStudySet(i, needStudyMap, canStudyMap, canStudySet);
            }
        }

        // 第二次遍历
        for (int i = 0; i < numCourses; i++) {
            if (!canStudySet.contains(i))
                return false;
        }

        return true;
    }

    /**
     * 当前课程能学之后,可以再学习哪些课程
     *
     * @param number       当前可以学的课程
     * @param needStudyMap
     * @param canStudyMap
     * @param canStudy
     */
    public void initCanStudySet(int number,
                                Map<Integer, Set<Integer>> needStudyMap,
                                Map<Integer, Set<Integer>> canStudyMap,
                                Set<Integer> canStudy) {
        if (!canStudyMap.containsKey(number))
            return;
        for (int i : canStudyMap.get(number)) {
            /**
             * 不加下面这样代码,超出时间限制……
             */
            if (canStudy.contains(i))
                continue;
            boolean can = true;
            for (int j : needStudyMap.get(i)) {
                if (!canStudy.contains(j)) {
                    can = false;
                    break;
                }
            }
            if (can) {
                canStudy.add(i);
                initCanStudySet(i, needStudyMap, canStudyMap, canStudy);
            }
        }
    }
}

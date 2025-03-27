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
public class Solution2025032702 {

    @Test
    public void test() {
        System.out.println(canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
    }

    /**
     * 呃,以为是并查集……
     * 看了答案好像不是……
     * <p>
     * 呃,尝试下面的组合失败了
     * 7,{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}
     * 输出:false
     * 预期:true
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] array : prerequisites) {
            Set<Integer> value = map.getOrDefault(array[0], new HashSet<>());
            value.add(array[1]);
            map.put(array[0], value);
        }
        Set<Integer> canStudy = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (canStudy.contains(i))
                continue;
            Set<Integer> needStudy = new HashSet<>();
            if (canFinish(i, map, canStudy, needStudy)) {
                canStudy.add(i);
                canStudy.addAll(needStudy);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(int number, Map<Integer, Set<Integer>> map, Set<Integer> canStudy, Set<Integer> needStudy) {
        if (canStudy.contains(number))
            return true;
        if (!map.containsKey(number))
            return true;
        if (needStudy.contains(number))
            return false;
        needStudy.add(number);
        for (int i : map.get(number)) {
            if (!canFinish(i, map, canStudy, needStudy)) {
                return false;
            }
        }
        return true;
    }
}

package com.test.leetcode.page3.chapter200.t207;

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
public class Solution2025032701 {

    /**
     * 这题应该是有新的算法,目前只能按自己的理解,尝试下了
     * <p>
     * 呃,尝试下面的组合失败了
     * 3,{{1,0},{1,2},{0,1}}
     * 返回true
     * 实际false
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] array : prerequisites) {
            map.put(array[0], array[1]);
        }
        Set<Integer> canStudy = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (canStudy.contains(i))
                continue;
            Set<Integer> needStudy = new HashSet<>();
            int number = i;
            while (!canStudy.contains(number) && map.containsKey(number)) {
                needStudy.add(number);
                number = map.get(number);
                if (needStudy.contains(number))
                    return false;
            }
            needStudy.add(number);
            canStudy.addAll(needStudy);
        }
        return true;
    }
}

package com.test.leetcode.page3.chapter260.t261;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230318
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/18 09:24
 * @Version: 1.0
 */
public class SolutionFirst20230318 {


    /**
     * 呃，好吧，这个算法行不通，因为是无向边
     * 3
     * [[1,0],[2,0]]
     * 输出false,预期true
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] array : edges) {
            if (set.contains(array[1])) {
                return false;
            }
            set.add(array[1]);
        }
        return set.size() == n - 1;
    }
}

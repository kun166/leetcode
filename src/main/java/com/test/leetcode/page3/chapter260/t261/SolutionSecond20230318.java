package com.test.leetcode.page3.chapter260.t261;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: SolutionSecond20230318
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/18 09:31
 * @Version: 1.0
 */
public class SolutionSecond20230318 {

    public boolean validTree(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> root = new HashSet<>();
        for (int[] array : edges) {
            // 无向边，如果set中存在，说明就做父节点了
            if (set.contains(array[0])) {
                if (root.contains(array[0])) {
                    return false;
                }
                root.add(array[0]);
            } else {
                set.add(array[0]);
            }

            if (set.contains(array[1])) {
                if (root.contains(array[1])) {
                    return false;
                }
                root.add(array[1]);
            } else {
                set.add(array[1]);
            }
        }
        return set.size() == n - 1;
    }
}

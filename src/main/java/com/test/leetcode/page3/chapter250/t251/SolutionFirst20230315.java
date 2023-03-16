package com.test.leetcode.page3.chapter250.t251;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Solution20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 09:46
 * @Version: 1.0
 */
public class SolutionFirst20230315 {

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了43.33%的用户
     * 内存消耗：46.4 MB, 在所有 Java 提交中击败了20.83%的用户
     */
    class Vector2D {

        Queue<Integer> queue = new LinkedList<>();

        public Vector2D(int[][] vec) {
            if (vec == null) {
                return;
            }
            for (int[] arr : vec) {
                for (int value : arr) {
                    queue.offer(value);
                }
            }
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}

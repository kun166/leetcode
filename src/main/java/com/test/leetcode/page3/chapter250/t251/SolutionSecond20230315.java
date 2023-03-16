package com.test.leetcode.page3.chapter250.t251;

import org.junit.Test;

/**
 * @ClassName: SolutionSecond20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 10:05
 * @Version: 1.0
 */
public class SolutionSecond20230315 {

    @Test
    public void test() {
        Vector2D vector2D = new Vector2D(new int[][]{{1, 2}, {3}, {4}});
        System.out.println(vector2D.next());
        System.out.println(vector2D.next());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：46.3 MB, 在所有 Java 提交中击败了33.33%的用户
     */
    class Vector2D {

        int m, n;
        int[][] vec;

        public Vector2D(int[][] vec) {
            this.vec = vec;
            m = n = -1;
            if (vec != null) {
                for (int i = 0; i < vec.length; i++) {
                    for (int j = 0; j < vec[i].length; j++) {
                        m = i;
                        n = j;
                        return;
                    }
                }
            }
        }

        public int next() {
            int value = vec[m][n];
            if (n == vec[m].length - 1) {
                n = 0;
                m++;
                while (m < vec.length && vec[m].length == 0) {
                    m++;
                }
            } else {
                n++;
            }
            return value;
        }

        public boolean hasNext() {
            if (vec == null || m == -1 || m >= vec.length) {
                return false;
            }
            return true;
        }
    }
}

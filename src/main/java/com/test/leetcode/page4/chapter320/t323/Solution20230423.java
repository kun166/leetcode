package com.test.leetcode.page4.chapter320.t323;

/**
 * @ClassName: Solution20230423
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/23 09:51
 * @Version: 1.0
 */
public class Solution20230423 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了89.13%的用户
     * 通过测试用例：44 / 44
     * <p>
     * 查并集啊，这个题如果再学不会，真的是无语了
     * 查并集的解法：
     * 1,先初始化自身的父节点是自身
     * 2,查，查询两个节点的父节点是否是同一个
     * 3,并，如果不是同一个，则并
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        for (int[] a : edges) {
            int r1 = find(array, a[0]), r2 = find(array, a[1]);
            if (r1 != r2) {
                array[r1] = r2;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == array[i]) {
                count++;
            }
        }
        return count;
    }

    public int find(int[] array, int i) {
        if (i == array[i]) {
            return i;
        }
        int parent = array[i];
        int root = find(array, parent);
        array[parent] = root;
        return root;
    }
}

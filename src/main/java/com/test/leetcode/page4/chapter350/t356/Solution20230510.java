package com.test.leetcode.page4.chapter350.t356;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Solution20230510
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/10 10:57
 * @Version: 1.0
 */
public class Solution20230510 {

    @Test
    public void test() {
        System.out.println(isReflected(new int[][]{{0, 0}, {1, 0}}));
    }

    /**
     * 呃，没官方解答，失败了七次才成功
     * 执行用时：7 ms, 在所有 Java 提交中击败了85.71%的用户
     * 内存消耗：44 MB, 在所有 Java 提交中击败了71.43%的用户
     * 通过测试用例：36 / 36
     *
     * @param points
     * @return
     */
    public boolean isReflected(int[][] points) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : points) {
            Set<Integer> set = map.get(arr[1]);
            if (set == null) {
                set = new HashSet<>();
                map.put(arr[1], set);
            }
            set.add(arr[0]);
        }
        Double y = null;
        for (Set<Integer> set : map.values()) {

            double curY;
            int sum = 0;
            // 找最大值最小值，然后确定中间值
            Integer left = null, right = null;
            for (int number : set) {
                if (left == null) {
                    left = number;
                }
                if (right == null) {
                    right = number;
                }
                if (left > number) {
                    left = number;
                }
                if (right < number) {
                    right = number;
                }
                sum += number;
            }
            // 呃，这个地方还涉及整除问题……
            curY = (left + right) / 2d;
            if (curY * set.size() != sum) {
                return false;
            }

            if (y == null) {
                y = curY;
            } else if (y != curY) {
                return false;
            }
        }
        return true;
    }
}

package com.test.leetcode.page4.chapter300.t305;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Solution20230408
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/8 7:46
 * @Version: 1.0
 */
public class Solution20230408 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}})));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        Set<Set<Integer>> set = new HashSet<>();
        for (int[] array : positions) {
            Set<Integer> first = null;
            Iterator<Set<Integer>> iterator = set.iterator();
            while (iterator.hasNext()) {
                Set<Integer> s = iterator.next();
                boolean contains = false;
                // 四个方向
                if (s.contains(getPosition(array[0] - 1, array[1]))
                        || s.contains(getPosition(array[0], array[1] - 1))
                        || s.contains(getPosition(array[0], array[1] + 1))
                        || s.contains(getPosition(array[0] + 1, array[1]))) {
                    contains = true;
                }
                if (contains) {
                    if (first == null) {
                        first = s;
                        first.add(getPosition(array[0], array[1]));
                    } else {
                        first.addAll(s);
                        iterator.remove();
                    }
                }
            }
            if (first == null) {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(getPosition(array[0], array[1]));
                set.add(newSet);
            }
            ans.add(set.size());
        }
        return ans;
    }

    private int getPosition(int x, int y) {
        return x * 10000 + y;
    }
}

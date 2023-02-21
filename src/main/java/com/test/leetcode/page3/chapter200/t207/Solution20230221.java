package com.test.leetcode.page3.chapter200.t207;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution20230221
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/21 09:09
 * @Version: 1.0
 */
public class Solution20230221 {

    @Test
    public void test() {
        System.out.println(canFinish(3, new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}));
    }

    /**
     * 这道题考察的感觉就是循环问题
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 先把prerequisites处理成key,Set的Map形式
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> set = map.get(prerequisites[i][0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(prerequisites[i][0], set);
            }
            set.add(prerequisites[i][1]);
        }
        // 这个记录已经被证明可以学的课程。
        Set<Integer> finishSet = new HashSet<>();
        // 本次map循环涉及到的所有key
        Set<Integer> currentSet = new HashSet<>();
        // 单链条涉及到的key
        // 如测试用例中给出的key为2时候,set对应{4,5},则单链条cycleSet中循环到4的时候是……2,4……，循环到5的时候是……2,5……
        // 就是说，如果一个key，对应的set里面有多个值，应该互补影响
        // 为了实现这个互不影响，引入了递归回溯，而不是单纯地递归
        Set<Integer> cycleSet = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            currentSet.clear();
            cycleSet.clear();
            if (canFinish(map, finishSet, currentSet, cycleSet, entry.getKey())) {
                finishSet.addAll(currentSet);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(Map<Integer, Set<Integer>> map,
                             Set<Integer> finishSet,
                             Set<Integer> currentSet,
                             Set<Integer> cycleSet,
                             int key) {
        if (finishSet.contains(key)) {
            return true;
        }
        if (!map.containsKey(key)) {
            finishSet.add(key);
            return true;
        }
        if (cycleSet.contains(key)) {
            return false;
        }
        // 在这个地方加，而不是在下面的for循环里面加，又悟到了一招
        cycleSet.add(key);
        boolean finish = true;
        for (Integer i : map.get(key)) {
            currentSet.add(i);
            finish = finish && canFinish(map, finishSet, currentSet, cycleSet, i);
            // 回溯
            cycleSet.remove(i);
        }
        return finish;
    }
}

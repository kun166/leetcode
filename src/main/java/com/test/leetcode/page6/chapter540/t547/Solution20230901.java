package com.test.leetcode.page6.chapter540.t547;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution20230901
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/1 10:10
 * @Version: 1.0
 */
public class Solution20230901 {

    @Test
    public void test() {
        int[][] array = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(findCircleNum(array));
    }

    /**
     * 这个题应该是一个拓扑
     * <p>
     * 35ms
     * 击败 5.45%使用 Java 的用户
     * 42.71MB
     * 击败 81.19%使用 Java 的用户
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int m = isConnected.length;
        // 这个只要遍历一半就行，另一半是对称的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (isConnected[i][j] == 1) {
                    if (i == j) {
                        if (!map.containsKey(i)) {
                            Set<Integer> set = new HashSet<>();
                            set.add(i);
                            map.put(i, set);
                        }
                    } else {
                        // 标识i和j相连,把i和j的城市囊裹进来
                        Set<Integer> setI = map.get(i);
                        Set<Integer> setJ = map.get(j);
                        if (setI == null) {
                            if (setJ == null) {
                                // 两者都为null
                                Set<Integer> set = new HashSet<>();
                                set.add(i);
                                set.add(j);
                                map.put(i, set);
                                map.put(j, set);
                            } else {
                                setJ.add(i);
                                map.put(i, setJ);
                            }
                        } else if (setJ == null) {
                            // setI 不为null
                            setI.add(j);
                            map.put(j, setI);
                        } else {
                            // 两者都不为null,将setJ转移到setI
                            setI.addAll(setJ);
                            for (Integer jj : setJ) {
                                map.put(jj, setI);
                            }
                        }
                    }
                }
            }
        }
        Set<Set<Integer>> ss = new HashSet<>(map.values());
        return ss.size();
    }
}

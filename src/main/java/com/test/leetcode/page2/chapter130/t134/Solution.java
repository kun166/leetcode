package com.test.leetcode.page2.chapter130.t134;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-20 17:05
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int step, current, remain, length = gas.length;
        for (int i = 0; i < length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            step = i;
            current = i + 1;
            remain = gas[i] - cost[i];
            while (step != current) {
                if (current == length) {
                    if (step == 0) {
                        return step;
                    }
                    current = current - length;
                }
                remain += gas[current] - cost[current];
                if (remain < 0) {
                    break;
                }
                current++;
            }
            if (step == current) {
                return step;
            }
        }
        return -1;
    }
}

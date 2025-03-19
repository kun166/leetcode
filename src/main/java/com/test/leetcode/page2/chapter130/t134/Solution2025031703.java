package com.test.leetcode.page2.chapter130.t134;

/**
 * @ClassName: Solution2025031703
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/18 08:53
 * @Version: 1.0
 */
public class Solution2025031703 {

    /**
     * 2ms	击败84.88%
     * 55.35MB	击败32.60%
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ) {
            if (gas[i] >= cost[i]) {
                int remain = 0, index, j;
                for (j = 0; j < gas.length; j++) {
                    index = i + j;
                    index = index >= gas.length ? index - gas.length : index;
                    remain += gas[index] - cost[index];
                    if (remain < 0) {
                        break;
                    }
                }
                if (j == gas.length)
                    return i;
                i = i + j;
            } else {
                i++;
            }
        }
        return -1;
    }
}

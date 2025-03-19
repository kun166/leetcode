package com.test.leetcode.page2.chapter130.t134;

/**
 * @ClassName: Solution2025031702
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/18 08:47
 * @Version: 1.0
 */
public class Solution2025031702 {

    /**
     * 还是超出时间限制……
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, n = gas.length;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0)
            return -1;

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i] && canCompleteCircuit(gas, cost, i))
                return i;
        }
        return -1;
    }

    public boolean canCompleteCircuit(int[] gas, int[] cost, int index) {
        int n = gas.length, remain = 0;
        for (int i = 0; i < n; i++) {
            /**
             * 唉唉唉，下面代码好大的坑啊
             * index += i;
             */
            if (index >= n)
                index -= n;
            remain += gas[index] - cost[index];
            if (remain < 0)
                return false;
            index++;
        }
        return true;
    }
}

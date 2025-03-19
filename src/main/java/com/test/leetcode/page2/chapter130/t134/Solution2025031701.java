package com.test.leetcode.page2.chapter130.t134;

import org.junit.Test;

/**
 * @ClassName: Solution2025031701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/17 10:40
 * @Version: 1.0
 */
public class Solution2025031701 {


    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    /**
     * 呃，这种算法,时间复杂度为n的平方?
     * <p>
     * 好吧，超出时间限制……
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
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

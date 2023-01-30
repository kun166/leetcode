package com.test.leetcode.page2.chapter130.t134;

/**
 * @ClassName: Other20230130
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/30 15:08
 * @Version: 1.0
 */
public class Other20230130 {

    /**
     * 这个解法的思路是：
     * 1,累加所有加油站的汽油sumGas，累加所有路上消耗的汽油sumUsed,
     * 如果sumGas>=sumUsed,则必然存在一个加油站作为起始加油站，能够走一圈。
     * 2,如果存在这个加油站，则寻找累加的存油量(这个因为题目给出了只有唯一一个解，所以这个值肯定是负值)最低的那个加油站，
     * 它的下一个加油站，即是寻找的那个加油站。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}

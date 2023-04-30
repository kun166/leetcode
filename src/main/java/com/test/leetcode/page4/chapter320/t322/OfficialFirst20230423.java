package com.test.leetcode.page4.chapter320.t322;

/**
 * @ClassName: OfficialFirst20230423
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/23 09:12
 * @Version: 1.0
 */
public class OfficialFirst20230423 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        // 第三个参数申请的数组长度为amount大
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * 寻找钱币为rem时候，零钱组合coins中使用的最少的金币数目
     *
     * @param coins 零钱面值
     * @param rem   钱币总金额
     * @param count 因为Java数字下标的问题,count[n-1]表示钱币总金额为n时，需要的最少金币数目
     * @return
     */
    private int coinChange(int[] coins, int rem, int[] count) {
        // 剩余的额度小于0，说明没有组合
        if (rem < 0) {
            return -1;
        }
        // 如果剩余的额度是0，则说明需要0个数量的金币
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            // 说明计算过了。这个地方一定要注意，count = new int[amount],由于Java数字下标从0开始，
            // 所以amount对应的下标是count[amount-1]
            return count[rem - 1];
        }
        // 给一个默认值，这个是记录需要的最少的金币数目
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 递归每一个面值的金币，找出最小值
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

}

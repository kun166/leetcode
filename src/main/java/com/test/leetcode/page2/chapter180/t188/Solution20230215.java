package com.test.leetcode.page2.chapter180.t188;

/**
 * @ClassName: Solution20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 09:38
 * @Version: 1.0
 */
public class Solution20230215 {

    /**
     * 买卖股票规律，[2,4,6,3,8,1,10]
     * 像上面的数组，从下标0开始
     * 1,遇到不大于它的数，则以它为起点，到该不大于它的数的下标截止，计算收益即可。
     * 2,从下标0到下标2，一直是升序，这个收益最好计算。也就是升序的收益最好计算。
     * 3,从下标0开始,到下标4结束，经历了升序,降序,升序，但是下标3的数值是3，大于下标0的2，如果购买次数未到上限，拆分赚的更多
     * 难点就在于有一个买卖上限K，怎么拆分啊
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        return 0;
    }
}

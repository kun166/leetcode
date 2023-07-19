package com.test.leetcode.page6.chapter510.t517;

import java.util.Arrays;

/**
 * @ClassName: Official20230719
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/19 08:37
 * @Version: 1.0
 */
public class Official20230719 {

    /**
     * 方法一：贪心
     *
     * @param machines
     * @return
     */
    public int findMinMoves(int[] machines) {
        // 求和
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            // 如果没法平均，则返回-1
            return -1;
        }
        // 求每台洗衣机的平均衣服量
        int avg = tot / n;
        int ans = 0, sum = 0;
        // 每操作一次，每台洗衣机只能向左或者向右转移一件衣服。因此最大的操作次数，可能出现在num-avg里(负数不讨论，因为如果是负数，左右两台洗衣机都可以向它转移)
        // 可以根据当前位置的洗衣机i，分为两部分,一部分是[1,i]计为A,另一部分是[i+1,n]计为B
        // 如果A衣服多，则A向B移动，否则，B向A移动，求绝对值即可
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }

}

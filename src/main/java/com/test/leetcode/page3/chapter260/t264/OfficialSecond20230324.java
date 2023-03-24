package com.test.leetcode.page3.chapter260.t264;

/**
 * @ClassName: OfficialSecond20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 09:27
 * @Version: 1.0
 */
public class OfficialSecond20230324 {

    /**
     * 不太好理解，继续理解
     * <p>
     * 关于dp的解法，其关键点就在于：
     * <p>
     * 1,当前的p2,p3,p5三个指针，它们所指向的丑数再乘以其各自对应的因数（即2，3，5），
     * 所得到的三个乘数必定是大于当前数组的最大丑数的；
     * 2,三个指针对应位置的前一个位置（即p2-1,p3-1,p5-1），它们所指向的丑数乘以各自的因数，
     * 所得的三个乘数必定小于等于当前数组的最大丑数。WHY?很简单，
     * 因为这三个乘数都已经被放入数组中了，
     * 不然的话对应的指针是不会移动的；
     * 明白了这两个点，dp就很好写了
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // p2是生成下一个数的时候,2有几个？
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            // dp[i] 取三数最小值
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                // 说明当前的dp[i]是通过乘以2之后得到的数
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

}

package com.test.leetcode.page3.chapter200.t202;

/**
 * @ClassName: OfficialSecond20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 17:05
 * @Version: 1.0
 */
public class OfficialSecond20230219 {
    /**
     * 快慢指针法
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}

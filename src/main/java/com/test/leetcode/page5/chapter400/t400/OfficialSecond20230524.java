package com.test.leetcode.page5.chapter400.t400;

/**
 * @ClassName: OfficialSecond20230524
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/24 09:41
 * @Version: 1.0
 */
public class OfficialSecond20230524 {

    /**
     * 方法二：直接计算
     * 呃， 看下方法一吧，这个计算更牛逼啊
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

}

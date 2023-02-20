package com.test.leetcode.page3.chapter200.t201;

/**
 * @ClassName: OfficialSecond20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 08:54
 * @Version: 1.0
 */
public class OfficialSecond20230220 {

    /**
     * 方法二：Brian Kernighan 算法
     * 该方法的前提是理解了解法一，为什么要进行位移。
     * <p>
     * Brian Kernighan 算法的关键在于我们每次对 number 和 number−1 之间进行按位与运算后，
     * number 中最右边的1 会被抹去变成0。
     * 例如number是1111，则number-1是1110,按位与之后是1110，最右侧的1变成了0
     * 如number是1100，则number-1是1011,按位与之后是1000
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}

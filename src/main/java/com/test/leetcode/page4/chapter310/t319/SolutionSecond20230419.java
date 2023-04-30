package com.test.leetcode.page4.chapter310.t319;

/**
 * @ClassName: SolutionSecond20230419
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/19 08:56
 * @Version: 1.0
 */
public class SolutionSecond20230419 {

    /**
     * 呃，我也不知道为什么平方的地方是true，我只是打印了100以内的数组，看了下都是平方的地方是true……
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了69.28%的用户
     * 通过测试用例：35 / 35
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        int ant = 0;
        while (ant * ant <= n) {
            ant++;
        }
        return ant - 1;
    }
}

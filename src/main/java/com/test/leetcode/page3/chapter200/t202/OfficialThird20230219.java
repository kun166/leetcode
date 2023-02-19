package com.test.leetcode.page3.chapter200.t202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: OfficialThird20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 17:08
 * @Version: 1.0
 */
public class OfficialThird20230219 {

    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    /**
     * 数学
     * 前两种方法是你在面试中应该想到的。第三种方法不是你在面试中会写的，而是针对对数学好奇的人，因为它很有趣。
     * 下一个值可能比自己大的最大数字是什么？根据我们之前的分析，我们知道它必须低于 243。因此，我们知道任何循环都必须包含小于 243 的数字，用这么小的数字，编写一个能找到所有周期的强力程序并不困难。
     * 如果这样做，您会发现只有一个循环：
     * 4→16→37→58→89→145→42→20→4。所有其他数字都在进入这个循环的链上，或者在进入1 的链上。
     * 因此，我们可以硬编码一个包含这些数字的散列集，如果我们达到其中一个数字，那么我们就知道在循环中。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
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

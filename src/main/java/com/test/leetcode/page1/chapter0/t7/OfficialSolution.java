package com.test.leetcode.page1.chapter0.t7;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 16:27
 */
public class OfficialSolution {


    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // Integer.MAX_VALUE值为2147483647，所以rev == Integer.MAX_VALUE / 10永远为假，后面这个判断条件可以省略掉了
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

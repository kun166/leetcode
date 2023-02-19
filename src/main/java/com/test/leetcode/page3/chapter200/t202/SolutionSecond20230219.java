package com.test.leetcode.page3.chapter200.t202;

/**
 * @ClassName: SolutionSecond20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 17:19
 * @Version: 1.0
 */
public class SolutionSecond20230219 {

    /**
     * 跟官方的解法学习学习
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = getNext(n);
        int fast = getNext(slow);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        if (fast == 1) {
            return true;
        }
        return false;
    }

    public int getNext(int n) {
        int number = 0;
        while (n > 0) {
            int value = n % 10;
            number += value * value;
            n = n / 10;
        }
        return number;
    }

}

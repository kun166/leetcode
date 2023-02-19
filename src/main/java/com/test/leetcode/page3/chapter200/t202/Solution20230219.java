package com.test.leetcode.page3.chapter200.t202;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 16:51
 * @Version: 1.0
 */
public class Solution20230219 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        do {
            int number = 0;
            while (n > 0) {
                int value = n % 10;
                number += value * value;
                n /= 10;
            }
            n = number;
            if (set.contains(n) && n != 1) {
                return false;
            }
            set.add(n);
        } while (n != 1);
        return true;
    }
}

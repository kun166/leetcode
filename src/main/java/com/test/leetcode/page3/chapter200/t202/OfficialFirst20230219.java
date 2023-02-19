package com.test.leetcode.page3.chapter200.t202;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: OfficialFirst20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 17:04
 * @Version: 1.0
 */
public class OfficialFirst20230219 {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

}

package com.test.leetcode.page3.chapter200.t202;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 14:28
 * @Version: 1.0
 */
public class Solution2025032601 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            int next = 0;
            while (n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;
        }
        return true;
    }

}

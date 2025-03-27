package com.test.leetcode.page3.chapter200.t204;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 09:02
 * @Version: 1.0
 */
public class Solution2025032701 {

    @Test
    public void test() {
        System.out.println(countPrimes(10));
    }

    /**
     * 超出时间限制
     * <p>
     * 2,3,5,7,
     * 11,13,17,19,
     * 23,29
     * 31,37,39
     * 41,43,47
     * 51,53,57,59
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i < n; i++) {
            if (isPrimes(i, list)) {
                ans++;
                list.add(i);
            }
        }
        return ans;
    }

    public boolean isPrimes(int n, List<Integer> list) {
        for (int number : list) {
            if (n % number == 0)
                return false;
            if (number * number > n)
                return true;
        }
        return true;
    }


}

package com.test.leetcode.page1.chapter20.t29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 17:46
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(divide(2147483647, 1));
    }

    /**
     * 这个有用负数去做计算的，负数计算就简单多了
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int result = 0;
        int divisorAbs, dividendAbs;
        boolean moreThanZero = false;
        if (Integer.MIN_VALUE == dividend) {
            if (Integer.MIN_VALUE == divisor) return 1;
            else if (1 == divisor) return Integer.MIN_VALUE;
            else if (-1 == divisor) return Integer.MAX_VALUE;
            divisorAbs = divisor < 0 ? -divisor : divisor;
            dividend += divisorAbs;
            result += 1;
            dividendAbs = dividend < 0 ? -dividend : dividend;
        } else if (Integer.MIN_VALUE == divisor) return 0;
        else {
            divisorAbs = divisor < 0 ? -divisor : divisor;
            dividendAbs = dividend < 0 ? -dividend : dividend;
        }
        if (dividend < 0 && divisor < 0) {
            moreThanZero = true;
        } else if (dividend > 0 && divisor > 0) {
            moreThanZero = true;
        }


        if (dividendAbs == divisorAbs) result += 1;
        else if (dividendAbs > divisorAbs) {
            // 从小到大存储被除数2的次方的数
            List<Integer> list = new ArrayList<>();
            // key是list存储得数，value是除数结果
            Map<Integer, Integer> map = new HashMap<>();
            int d = divisorAbs;
            int r = 1;
            while (d < dividendAbs && d > 0) {
                // 每次数是上一个数的2倍
                list.add(d);
                map.put(d, r);
                d += d;
                r += r;
            }
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                int cv = list.get(i);
                if (cv < dividendAbs) {
                    dividendAbs -= cv;
                    result += map.get(cv);
                }
            }
            if (dividendAbs >= divisorAbs) {
                result++;
            }
        }

        if (moreThanZero) {
            return result;
        } else {
            return -result;
        }
    }
}

package com.test.leetcode.page4.chapter300.t306;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @ClassName: Solution20230413
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/13 16:40
 * @Version: 1.0
 */
public class Solution20230413 {

    @Test
    public void test() {
        System.out.println(isAdditiveNumber("12122436"));
    }

    /**
     * 提交了N次，也没通过，唉
     *
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        // 先寻找起始位置符合要求的
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int maxL = Math.max(i + 1, j - i);
                BigDecimal first = new BigDecimal(num.substring(0, i + 1));
                BigDecimal second = new BigDecimal(num.substring(i + 1, j + 1));
                if (j + 1 >= length) {
                    continue;
                }

                if (maxL + j + 1 <= length) {
                    if (maxL > 1 && num.charAt(j + 1) == '0') {
                        continue;
                    }
                    BigDecimal result = new BigDecimal(num.substring(j + 1, j + 1 + maxL));
                    if (first.add(second).compareTo(result) == 0 && isAdditiveNumber(num, second, result, j + 1 + maxL, maxL)) {
                        return true;
                    }
                }
                if (maxL + j + 1 < length) {
                    maxL++;
                    if (maxL > 1 && num.charAt(j + 1) == '0') {
                        continue;
                    }
                    BigDecimal result = new BigDecimal(num.substring(j + 1, j + 1 + maxL));
                    if (first.add(second).compareTo(result) == 0 && isAdditiveNumber(num, second, result, j + 1 + maxL, maxL)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num, BigDecimal first, BigDecimal second, int index, int maxL) {
        if (num.length() == index) {
            return true;
        }
        if (maxL > 1 && num.charAt(index) == '0') {
            return false;
        }
        BigDecimal result = new BigDecimal(num.substring(index, index + maxL));
        if (first.add(second).compareTo(result) == 0) {
            return isAdditiveNumber(num, second, result, index + maxL, maxL);
        }
        maxL++;
        result = new BigDecimal(num.substring(index, index + maxL));
        if (first.add(second).compareTo(result) == 0) {
            return isAdditiveNumber(num, second, result, index + maxL, maxL);
        }
        return false;
    }
}

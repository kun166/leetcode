package com.test.leetcode.page1.chapter0.t7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @ClassName: Solution
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/16 20:23
 * @Version: 1.0
 */
@Slf4j
public class Solution {

    @Test
    public void test() {
        System.out.println(reverse(1234));
        log.info(String.valueOf(Integer.MAX_VALUE));
        log.info(String.valueOf(Integer.MIN_VALUE));
    }

    public int reverse(int x) {
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}

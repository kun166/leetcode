package com.test.test;

import org.junit.Test;

/**
 * 位运算
 *
 * @ClassName: BitCompute
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 09:43
 * @Version: 1.0
 */
public class BitCompute {

    @Test
    public void test1() {
        System.out.println(108 ^ Integer.MAX_VALUE ^ Integer.MAX_VALUE);
    }
}

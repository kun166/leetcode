package com.test.test;

import org.junit.Test;

/**
 * @ClassName: OuterLoopTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/14 11:30
 * @Version: 1.0
 */
public class OuterLoopTest {

    @Test
    public void test() {
        outerLoop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i * j == 20) {
                    break;
                }
                if (i * j == 36) {
                    continue outerLoop;
                }
                if (i * j == 64) {
                    break outerLoop;
                }
                System.out.println("i:" + i + ";j:" + j);
            }
        }
    }

}

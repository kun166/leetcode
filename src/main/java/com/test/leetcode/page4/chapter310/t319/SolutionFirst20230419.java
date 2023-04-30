package com.test.leetcode.page4.chapter310.t319;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20230419
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/19 08:34
 * @Version: 1.0
 */
public class SolutionFirst20230419 {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            bulbSwitch(i);
        }
    }

    /**
     * 呃，超出时间限制。看来这种方式不太行啊
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        boolean[] array = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j = j + i) {
                array[j] = !array[j];
            }
        }
        int ant = 0;
        for (int i = 0; i < n; i++) {
            if (array[i]) {
                ant++;
            }
        }
        System.out.println(n + ":" + JSON.toJSONString(array));
        return ant;
    }
}

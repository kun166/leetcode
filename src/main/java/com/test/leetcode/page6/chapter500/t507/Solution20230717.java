package com.test.leetcode.page6.chapter500.t507;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230717
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/17 08:56
 * @Version: 1.0
 */
public class Solution20230717 {

    @Test
    public void test() {
        System.out.println(checkPerfectNumber(15));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了45.76%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了74.59%的用户
     * 通过测试用例：98 / 98
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i < num; i++) {
            if (i * i > num) {
                break;
            }
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }
        for (int i : list) {
            num -= i;
        }
        return num == 0;
    }
}

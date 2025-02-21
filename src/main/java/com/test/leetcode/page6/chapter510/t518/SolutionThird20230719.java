package com.test.leetcode.page6.chapter510.t518;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionSecond20230719
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/19 10:19
 * @Version: 1.0
 */
public class SolutionThird20230719 {

    Map<String, Integer> map = new HashMap<>();

    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    /**
     * 执行用时：192 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗：54.9 MB, 在所有 Java 提交中击败了5.15%的用户
     * 通过测试用例：28 / 28
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return change(amount, coins, coins.length - 1);
    }

    public int change(int amount, int[] coins, int index) {
        if (map.containsKey(amount + "_" + index)) {
            return map.get(amount + "_" + index);
        }
        if (amount == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = index; i >= 0; i--) {
            if (amount >= coins[i]) {
                ans += change(amount - coins[i], coins, i);
            }
        }
        map.put(amount + "_" + index, ans);
        return ans;
    }
}

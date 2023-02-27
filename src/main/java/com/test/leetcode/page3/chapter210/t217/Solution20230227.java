package com.test.leetcode.page3.chapter210.t217;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230227
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/27 20:26
 * @Version: 1.0
 */
public class Solution20230227 {

    @Test
    public void test() {
        System.out.println(1 ^ 2 ^ 3);
    }

    /**
     * 这题感觉这种做法有点没意思吧？
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}

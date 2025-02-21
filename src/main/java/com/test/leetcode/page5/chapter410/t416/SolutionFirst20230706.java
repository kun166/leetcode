package com.test.leetcode.page5.chapter410.t416;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: SolutionFirst20230706
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/6 15:37
 * @Version: 1.0
 */
public class SolutionFirst20230706 {

    /**
     * 执行用时：52 ms, 在所有 Java 提交中击败了12.06%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了42.90%的用户
     * 通过测试用例：141 / 141
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i == half) {
                return true;
            }
            if (set.contains(half - i)) {
                return true;
            }
            Integer[] array = new Integer[set.size()];
            array = set.toArray(array);
            for (int j : array) {
                set.add(j + i);
            }
            set.add(i);
        }
        return false;
    }
}

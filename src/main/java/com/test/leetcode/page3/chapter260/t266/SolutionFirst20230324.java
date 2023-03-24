package com.test.leetcode.page3.chapter260.t266;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 16:20
 * @Version: 1.0
 */
public class SolutionFirst20230324 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了47.83%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了46.74%的用户
     * 通过测试用例：24 / 24
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() < 2;
    }
}
